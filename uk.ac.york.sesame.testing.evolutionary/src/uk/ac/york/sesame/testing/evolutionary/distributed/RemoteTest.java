package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.GenericVariable;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.StaticVariable;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.ConfigTransformer;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.ConfigTransformerFactory;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.InvalidExecutorForOperation;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.InvalidTransformerForVariable;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.StaticOperationExecutoryFactory;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.TransformFailed;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.OperationExecutor;

public class RemoteTest implements Comparable<RemoteTest> {
	private String testID;
	private SOPRANODistributedExperiment expt;
	private TestStatus status = TestStatus.RUNNING;
	private SESAMETestSolution solution;
	
	private Optional<String> testRunUUID;
	
	public RemoteTest(String testID, SOPRANODistributedExperiment expt, SESAMETestSolution solution) {
		this.testID = testID;
		this.expt = expt;
		this.solution = solution;
	}
	
	public static RemoteTest fromSolution(SESAMETestSolution s, SOPRANODistributedExperiment expt) {
		String testID = s.getInternalType().getName();
		return new RemoteTest(testID, expt, s);
	}

	public String getTestID() {
		return testID;
	}

	public void registerRunID(String testRunID) {
		// TODO Auto-generated method stub
		this.testRunUUID = Optional.of(testRunID);	
	}
	
	public synchronized void handleStaticFuzzingForTest(Random rng, RemoteTest rt) {
		ConfigTransformerFactory ctFactory = new ConfigTransformerFactory();
		StaticOperationExecutoryFactory soFactory = new StaticOperationExecutoryFactory();
	
		try {
		SESAMETestSolution sol = rt.getSolution();
		// For all fuzzing operations, find the static variables
		List<PotentiallyStaticOperation> staticOps = sol.getAllStaticOperations();
		// This verifies that all operations returned should be static variables
		for (PotentiallyStaticOperation op : staticOps) {
			
			GenericVariable gv = op.getVariableToAffect();
			if (gv instanceof StaticVariable) {
				StaticVariable sv = (StaticVariable)gv;
				List<ConfigTransformer> tfs = ctFactory.createTransformers(this, sv);
				for (ConfigTransformer tf : tfs) {
					// Need some sort of executor for the operation here
					OperationExecutor exec = soFactory.createOperationExecutor(op);
					tf.transform(rng,exec);
				}
				sv.getLocations();
				
			} else {
				System.err.println("handleStaticFuzzingForTest: not a static variable - " + gv.toString());
				System.exit(-1);
			}
		}
		} catch (InvalidTransformerForVariable e) {
			e.printStackTrace();
		} catch (InvalidExecutorForOperation e) {
			e.printStackTrace();
		} catch (TransformFailed e) {
			e.printStackTrace();
		}
	}
	
	public Optional<String> getRunUUID() {
		return testRunUUID;
	}

	public int compareTo(RemoteTest other) {
		return testID.compareTo(other.testID);
	}

	public void setStatus(TestStatus testStatus) {
		this.status = testStatus;
	}
	
	public boolean isStillRunning() {
		return (this.status == TestStatus.RUNNING);
	}
	
	public SESAMETestSolution getSolution() {
		return solution;
	}
}
