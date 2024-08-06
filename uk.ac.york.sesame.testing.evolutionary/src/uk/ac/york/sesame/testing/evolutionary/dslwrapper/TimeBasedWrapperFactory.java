//package uk.ac.york.sesame.testing.evolutionary.dslwrapper;
//
//import java.security.SecureRandom;
//
//import org.eclipse.emf.ecore.util.EcoreUtil;
//
//import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
//import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DynamicOperation;
//import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
//import uk.ac.york.sesame.testing.evolutionary.ParamError;
//
//public class TimeBasedWrapperFactory extends FuzzingOperationWrapperFactory {
////	@Override
////	public FuzzingOperationWrapper reductionOfOperation(SecureRandom rng, DynamicOperation original) {
////		FuzOperation newA = EcoreUtil.copy(original);
////		newA.setFromTemplate(original);
////		reduceAttackActivationsTiming(newA, original.getActivation());
////		newA.setSeed(rng.nextLong());
////
////		try {
////			reduceOperationSpecific(newA, original);
////		} catch (ParamError e) {
////			e.printStackTrace();
////		}
////		return new TimeBasedOperationWrapper(newA);
////	}
////
////	@Override
////	public FuzzingOperation reduceOperationSpecific(FuzzingOperation op, FuzzingOperation original) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	@Override
//	public FuzzingOperationWrapper createFromDSLObject(FuzzingOperation a) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	@Override
////	public FuzzingOperationWrapper reductionOfOperation(FuzzingOperationWrapperFactory wf, SecureRandom rng)
////			throws InvalidOperationForReduction {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}
