package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionTarget;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.SOPRANOWorkerNode;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

public class SOPRANOExperimentManager implements SolutionListEvaluator<SESAMETestSolution> {
	// Determines the allocation of tasks to workers
	// Sends the commands to the remote worker daemons
	// Polls and checks their status periodically

	private static final long serialVersionUID = 1L;
	// Status monitors - each create a MetricMonitor when they are ready
	List<RemoteStatusMonitor> remoteStatusMonitors = new ArrayList<RemoteStatusMonitor>();
	
	// These are the tests that are pending allocation to any worker
	PriorityQueue<RemoteTest> unallocatedTestQueue = new PriorityQueue<RemoteTest>();
	
	// These are the tests that have been allocated, and are pending/running on the workers
	Set<RemoteTest> pendingRunningTests = new HashSet<RemoteTest>();
	
	// These are the tests the workers have completed
	Set<RemoteTest> completedTests = new HashSet<RemoteTest>();

	Set<WorkerNode> availableNodes = new HashSet<WorkerNode>();
	
	// This is the allocation of pending/running tests on worker nodes
	Map<WorkerNode, List<RemoteTest>> allocationMapping;
	
	AllocationStrategy workerAllocationStrategy;
	SOPRANODistributedExperiment activeExperiment;

	private Thread loopThread;

	public SOPRANOExperimentManager(SOPRANODistributedExperiment expt, AllocationStrategy workerAllocationStrat) {
		// How to set the dependencies needed?
		this.activeExperiment = expt;
		this.workerAllocationStrategy = new UpFrontAllocation();
		this.allocationMapping = new HashMap<WorkerNode, List<RemoteTest>>();

		// Prepare the allocation manager thread
		loopThread = new Thread() {
			public void run() {
				allocationLoop();
			}
		};
	}

	public void registerAvailableWorker(WorkerNode workerNode) {
		availableNodes.add(workerNode);
		allocationMapping.put(workerNode, new ArrayList<>());
	}

	public void registerTest(RemoteTest test) {
		System.out.println("Registering test " + test.getTestID());
		unallocatedTestQueue.add(test);
	}

	private void allocationLoop() {
		try {
			
			while (!activeExperiment.isCompleted()) {
				
				// Need to wait until code generation is completed here!
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Running allocation loop in SOPRANOExperimentManager..." + availableNodes.size()	+ " workers available");
				if (unallocatedTestQueue.size() > 0) {
					RemoteTest t = unallocatedTestQueue.remove();
					pendingRunningTests.add(t);

					Optional<WorkerNode> node_o = workerAllocationStrategy.allocateTest(t, availableNodes, allocationMapping);
					if (node_o.isPresent()) {
						WorkerNode node = node_o.get();
						System.out.println("Allocating test " + t.getTestID() + " to worker " + node.toString());
						// Register test, create new status monitor for test
						node.submitTest(t);
						// Add to mapping inside the allocation strategy
						registerAllocationMapping(t, node);
						RemoteStatusMonitor rsm = new RemoteStatusMonitor(this, t, node);
						remoteStatusMonitors.add(rsm);
						rsm.start();
						// TODO: ensure the remote status monitors are removed on exit of that simulation
					} else {
						System.out.println("Allocation of test " + t.getTestID() + " failed!");
					}
				}
			}
		} catch (AllocationFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOPRANORemoteError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void startLoopThread() {
		loopThread.start();
	}

	@Override
	public List<SESAMETestSolution> evaluate(List<SESAMETestSolution> solutionList,	Problem<SESAMETestSolution> problem) {
		TestCampaign selectedCampaign = activeExperiment.getCampaign();

		// Create a RemoteTest from each solution
		// Some processing is needed to ensure the model is properly updated first
		for (SESAMETestSolution solution : solutionList) {
			RemoteTest rt = RemoteTest.fromSolution(solution, activeExperiment);
			solution.setOperationSequenceNums();
			solution.ensureModelUpdated(selectedCampaign);
			registerTest(rt);
		}
		
		// Before submitting the test to the queue, ensure that code generation is up to date!
		// and the experiment files are synced to the remote PC
		activeExperiment.generateAllCode();
		activeExperiment.synchroniseFiles();		
		
		waitForMetrics();
		// By this point, all the tests have been executed - ensure the
		// model is updated
		activeExperiment.saveModel();
 		return solutionList;
	}
	
	public void dynamicallySaveModel() {
		activeExperiment.saveModel();
	}

	private void waitForMetrics() {
		boolean done = false;
		while (!done) {
			System.out.println("unallocatedTests queue size = " + unallocatedTestQueue.size() + ",allocatedPending size = " + pendingRunningTests.size());
			// TODO: rename these concepts here
			if ((unallocatedTestQueue.size() == 0) && (pendingRunningTests.size() == 0)) {
				done = true;
			}
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Callback for the status monitor to register that a test was done
	public synchronized void notifyTestCompletion(RemoteTest t) throws TestNotRunning {
		if (pendingRunningTests.contains(t)) {
			pendingRunningTests.remove(t);
			completedTests.add(t);
		} else {
			throw new TestNotRunning(t);
		}
		
		removeAllocationMapping(t);
	}
	
	private void registerAllocationMapping(RemoteTest t, WorkerNode node) {
		allocationMapping.get(node).add(t);
	}

	private void removeAllocationMapping(RemoteTest t) {
		// TODO: check that this removes it!
		for (List<RemoteTest> tests : allocationMapping.values()) {
			tests.remove(t);
		}
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	public void autoDetectWorkers() {
		// TODO Auto-generated method stub
		
	}

	public void registerExecutionTarget(ExecutionTarget et) {
		if (et instanceof SOPRANOWorkerNode) {
			SOPRANOWorkerNode dslEt = (SOPRANOWorkerNode)et;
			WorkerNode node = new WorkerNode(dslEt.getIpAddress());
			this.registerAvailableWorker(node);
		}
	}
}
