package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors;

import java.util.List;
import java.util.Random;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.evolutionary.dslwrapper.InvalidOperation;

public class RandomValueFromSetExecutor extends OperationExecutor {
	private RandomValueFromSetOperation rop;

	public RandomValueFromSetExecutor(RandomValueFromSetOperation rop) {
		this.rop = rop;
	}

	@Override
	public Object exec(Random rng, Object input) throws InvalidOperation {
		List<ValueSet> vs = rop.getValueSet();

		for (ValueSet v : vs) {
			if (v instanceof DoubleRange) {
				DoubleRange dr = (DoubleRange) v;
				double lower = dr.getLowerBound();
				double upper = dr.getUpperBound();
				double inputD = Double.parseDouble(input.toString());
				double genVal = (upper - lower) * rng.nextDouble();

				if (rop.isIsRelative()) {
					return inputD + genVal;
				} else {
					return genVal;
				}
			}

			
		}
		throw new InvalidOperation();
	}
}
