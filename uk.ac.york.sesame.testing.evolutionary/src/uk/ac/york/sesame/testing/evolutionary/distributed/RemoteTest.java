package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.DynamicVariable;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.GenericVariable;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ROSSimulator;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.SimVariableConfiguration;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Simulator;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.StaticVariable;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

import uk.ac.york.sesame.testing.evolutionary.distributed.remapping.*;
import uk.ac.york.sesame.testing.evolutionary.distributed.remapping.transformers.ConfigTransformer;
import uk.ac.york.sesame.testing.evolutionary.distributed.remapping.transformers.ConfigTransformerFactory;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.InvalidExecutorForOperation;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.InvalidTransformerForVariable;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.StaticOperationExecutoryFactory;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.TransformFailed;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.OperationExecutor;
import uk.ac.york.sesame.testing.evolutionary.dslwrapper.FuzzingOperationWrapper;
import uk.ac.york.sesame.testing.evolutionary.dslwrapper.InvalidFuzzingOperation;

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
	
	public void ensureRemappingsForTest() {
		// Need to get the MRS information to find out what type of simulation is used in this model
		MRS mrs = expt.getMRS();
		Simulator sim = mrs.getSimulator();
		EList<SimVariableConfiguration> svc = sim.getVarConfigs();
		SimulationRemapperFactory srFactory = new SimulationRemapperFactory();
		try {
			SimulationRemapper sr = srFactory.createRemapping(sim);
			for (SimVariableConfiguration sv : svc) {
				System.out.println("Performing remapping for dynamic variable " + sv.getVar().getName());
				sr.performRemappingForVariable(this, sv);
			}
		} catch (SimulationTypeNotRecognisedForRemapping e) {
			e.printStackTrace();
		} catch (InvalidSimulatorVariableType e) {
			e.printStackTrace();
		} catch (InvalidTransformerForVariable e) {
			e.printStackTrace();
		} catch (TransformFailed e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void handleStaticFuzzingForTest(Random rng) {
		ConfigTransformerFactory ctFactory = new ConfigTransformerFactory();
		StaticOperationExecutoryFactory soFactory = new StaticOperationExecutoryFactory();
	
		try {
		SESAMETestSolution sol = this.getSolution();
		// For all fuzzing operations, find the static variables
		List<FuzzingOperation> staticOps = sol.getAllStaticOperations();
		
		for (FuzzingOperation op : staticOps) {
			FuzzingOperationWrapper wrop = new FuzzingOperationWrapper(op);
			Optional<GenericVariable> gv_o = wrop.getVariableToAffect();

			// This verifies that all operations processed are static
			if ((gv_o.isPresent()) && (gv_o.get() instanceof StaticVariable)) {
				GenericVariable gv = gv_o.get();
				StaticVariable sv = (StaticVariable)gv;
				List<ConfigTransformer> tfs = ctFactory.createTransformers(this, sv);
				for (ConfigTransformer tf : tfs) {
					OperationExecutor exec = soFactory.createOperationExecutor(op);
					tf.transform(rng,exec);
				}
				sv.getLocations();
			} else {
				System.err.println("handleStaticFuzzingForTest: missing variable or not a static variable - " + gv_o.toString());
				System.exit(-1);
			}
		}
		} catch (InvalidTransformerForVariable e) {
			e.printStackTrace();
		} catch (InvalidExecutorForOperation e) {
			e.printStackTrace();
		} catch (TransformFailed e) {
			e.printStackTrace();
		} catch (InvalidFuzzingOperation e) {
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
