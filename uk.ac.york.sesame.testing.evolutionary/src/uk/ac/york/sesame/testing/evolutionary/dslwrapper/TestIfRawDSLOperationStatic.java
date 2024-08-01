package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation;

public class TestIfRawDSLOperationStatic {

	public static boolean isStatic(FuzzingOperation o) {
		if (o instanceof PotentiallyStaticOperation) {
			PotentiallyStaticOperation po = (PotentiallyStaticOperation)o;
			if (po.getActivation() == null) {
				return true;
			}
		}
		
		return false;
	}
}
