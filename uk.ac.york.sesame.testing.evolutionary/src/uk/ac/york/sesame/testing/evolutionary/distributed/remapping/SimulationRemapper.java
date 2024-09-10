package uk.ac.york.sesame.testing.evolutionary.distributed.remapping;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.SimVariableConfiguration;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Simulator;
import uk.ac.york.sesame.testing.evolutionary.distributed.RemoteTest;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.InvalidTransformerForVariable;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.TransformFailed;

public abstract class SimulationRemapper {
	protected Simulator sim;
	
	public SimulationRemapper(Simulator sim) {
		this.sim = sim;
	}

	public abstract void performRemappingForVariable(RemoteTest rt, SimVariableConfiguration sv) throws InvalidSimulatorVariableType, InvalidTransformerForVariable, TransformFailed;
}
