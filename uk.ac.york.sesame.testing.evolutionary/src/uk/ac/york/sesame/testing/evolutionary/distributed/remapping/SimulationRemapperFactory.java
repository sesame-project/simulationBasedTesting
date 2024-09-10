package uk.ac.york.sesame.testing.evolutionary.distributed.remapping;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ROSSimulator;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Simulator;


public class SimulationRemapperFactory {

	public SimulationRemapper createRemapping(Simulator sim) throws SimulationTypeNotRecognisedForRemapping {
		// TODO: other simulators
		if (sim instanceof ROSSimulator) {
			return new ROSRemapper(sim);
		}
		
		throw new SimulationTypeNotRecognisedForRemapping();
	}
	
}
