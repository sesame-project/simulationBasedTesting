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

import net.razorvine.pyro.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class SOPRANOExperimentManager implements SolutionListEvaluator<SESAMETestSolution> {
	// Determines the allocation of tasks to workers
	// Sends the commands to the remote worker daemons
	// Polls and checks their status periodically

	// How to handle the metrics that are received - should have different monitor
	// for each?

	// Status monitors
	List<RemoteStatusMonitor> remoteStatusMonitors = new ArrayList<RemoteStatusMonitor>();
	PriorityQueue<RemoteTest> pendingTestQueue = new PriorityQueue<RemoteTest>();

	// Replace with map of test status?
	Set<RemoteTest> runningTests = new HashSet<RemoteTest>();
	Set<RemoteTest> completedTests = new HashSet<RemoteTest>();

	Set<WorkerNode> availableNodes = new HashSet<WorkerNode>();
	Map<RemoteTest, WorkerNode> allocationMapping;

	AllocationStrategy workerAllocationStrategy;
	SOPRANODistributedExperiment activeExperiment;

	private Thread loopThread;

	public SOPRANOExperimentManager(SOPRANODistributedExperiment expt, AllocationStrategy workerAllocationStrat) {
		// How to set the dependencies needed?
		this.activeExperiment = expt;
		this.workerAllocationStrategy = new RoundRobinAllocation();
		this.allocationMapping = new HashMap<RemoteTest, WorkerNode>();

		// Prepare the allocation manager thread
		loopThread = new Thread() {
			public void run() {
				allocationLoop();
			}
		};
	}

	public void registerAvailableWorker(WorkerNode workerNode) {
		availableNodes.add(workerNode);
	}

	public void registerTest(RemoteTest test) {
		System.out.println("Registering test " + test.getTestID());
		pendingTestQueue.add(test);
	}

	private boolean allRunningTestsCompleted() {
		return (runningTests.size() == 0);
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
				if (pendingTestQueue.size() > 0) {
					RemoteTest t = pendingTestQueue.remove();

					Optional<WorkerNode> node_o = workerAllocationStrategy.allocateTest(t, availableNodes, allocationMapping);
					if (node_o.isPresent()) {
						WorkerNode node = node_o.get();
						System.out.println("Allocating test " + t.getTestID() + " to worker " + node.toString());
						// Register test, create new status monitor for test
						node.submitTest(t);
						// TODO: add to mapping inside the allocation strategy
						allocationMapping.put(t, node);
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

	// Callback for the completion monitor to register that a test was done
	public synchronized void registerTestCompletion(RemoteTest t) {
		runningTests.remove(t);
		completedTests.add(t);
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

		// By this point, all the tests have been executed
		return solutionList;
	}

	private void waitForMetrics() {
		// TODO: implement metric returning - until now hang here
		while (true) {
			
		}
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}
}
