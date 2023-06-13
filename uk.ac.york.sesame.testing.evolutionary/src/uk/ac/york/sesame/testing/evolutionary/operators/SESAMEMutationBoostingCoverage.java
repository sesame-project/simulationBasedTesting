package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Random;

import uk.ac.york.sesame.testing.evolutionary.phytestingselection.DimensionID;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.MissingDimensionsInMap;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.coveragechecker.CoverageCheckingAlg;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.ParameterSpaceDimensionalityReduction;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.evolutionary.ConditionGenerator;
import uk.ac.york.sesame.testing.evolutionary.SESAMEFuzzingOperationWrapper;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

public class SESAMEMutationBoostingCoverage extends SESAMESimpleMutation {

	private static final long serialVersionUID = 1L;

	private static final int TRY_LIMIT = 10;

	private CoverageCheckingAlg coverageCheckingAlg;
	private ParameterSpaceDimensionalityReduction dimensionReducer; 
	
	public SESAMEMutationBoostingCoverage(Random rng, String mutationLogFileName, double probTemporalMut,
			double probParamMut, ConditionGenerator cg) throws IOException {
		super(rng, mutationLogFileName, probTemporalMut, probParamMut, cg);
	}
	
	public void setCoverageChecker(CoverageCheckingAlg coverageCheckingAlg) {
		this.coverageCheckingAlg = coverageCheckingAlg;
	}
	
	public void setDimensionReducer(ParameterSpaceDimensionalityReduction dimensionReducer) {
		this.dimensionReducer = dimensionReducer;
	}

	private boolean checkOccupationForSolution(SESAMETestSolution solTest) {
		Test t = solTest.getInternalType();
		EnumMap<DimensionID, Double> dimPoint;
		try {
			dimPoint = dimensionReducer.generateDimensionSetsForParams(t);
			return coverageCheckingAlg.isCellOccupied(t, dimPoint);
		} catch (MissingDimensionsInMap e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public SESAMETestSolution execute(SESAMETestSolution sol) {
		try {
			// Pre-mutation debugging
			mutationLog.write(sol.toString() + "\n");
			for (int i = 0; i < sol.getNumberOfVariables(); i++) {
				SESAMEFuzzingOperationWrapper sta = sol.getVariable(i);
				System.out.println("Before modification SESAMETestAttack=" + sta);
				
				int tries = 0;
				SESAMETestSolution newTry = sol;
				boolean ok = !(checkOccupationForSolution(sol));
				while (!ok && (tries < TRY_LIMIT)) {
					mutationLog.write("First try at finding an uncovered solution: Trying new solution " + newTry);
					// Try attempts to mutate with original operation
					newTry = super.execute(sol); 
					// Issue is that we cannot check occupation for the solution before 
					// actually executing it, since only then do we know the occupation of
					// the temporal dimensions!
					ok = (!checkOccupationForSolution(newTry));
					tries++;
				}
				// TODO: need to modify the original values here 
				sol = newTry;
			}
			
			// Post-mutation debugging
			mutationLog.write(sol.toString() + "\n");
			mutationLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sol;
	}

	public void closeLog() throws IOException {
		mutationLog.close();
	}
}
