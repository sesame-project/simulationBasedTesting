package uk.ac.york.sesame.testing.evolutionary.distributed.test;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackageFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.DistributedExecutionStrategy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackageFactory;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.distributed.RemoteStatusMonitor;
import uk.ac.york.sesame.testing.evolutionary.distributed.RemoteTest;
import uk.ac.york.sesame.testing.evolutionary.distributed.SOPRANODistributedExperiment;
import uk.ac.york.sesame.testing.evolutionary.distributed.SOPRANOExperimentManager;
import uk.ac.york.sesame.testing.evolutionary.distributed.WorkerNode;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class TestRemoteMonitors {
	
	static TestingPackageFactory tf = TestingPackageFactory.eINSTANCE;
	FuzzingOperationsFactory ff = FuzzingOperationsFactory.eINSTANCE;
	static ExecutionFactory ef = ExecutionFactory.eINSTANCE;
	MRSPackageFactory mf = MRSPackageFactory.eINSTANCE;
	
	private static final int WORKER_COUNT = 100;
	private static SOPRANOExperimentManager manager = null;
	private static WorkerNode remoteWorker = new WorkerNode("192.168.1.238");
	private static TestCampaign tc = tf.createTestCampaign();
	private static SESAMEModelLoader loader = new SESAMEModelLoader("/tmp/test.model");
	private static DistributedExecutionStrategy distExec = ef.createDistributedExecutionStrategy();
	// These params are not needed since not doing code generation
	private static MRS mrs = null;
	private static SOPRANODistributedExperiment distributedExpt = new SOPRANODistributedExperiment(tc, distExec, loader, "", "", mrs);
	
	public static void createMonitor(int count) {
		System.out.println("Creating monitor " + count);
		// RemoteTest(String testID, SOPRANODistributedExperiment expt, SESAMETestSolution solution)
		String testID = "test" + Integer.toString(count);
		
		SESAMETestSolution sol = new SESAMETestSolution(tc);
		RemoteTest remoteTest = new RemoteTest(testID, distributedExpt, sol);
		// Run ID doesn't matter in this test
		remoteTest.registerRunID("eijrujuewuehuuhhueuh");
		RemoteStatusMonitor rsm = new RemoteStatusMonitor(manager, remoteTest, remoteWorker); 
		rsm.start();
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < WORKER_COUNT; i++) {
			createMonitor(i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
