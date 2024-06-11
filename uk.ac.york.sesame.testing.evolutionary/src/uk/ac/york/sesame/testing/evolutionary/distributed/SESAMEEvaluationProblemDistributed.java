package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.Optional;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.MissingGrammarFile;
import uk.ac.york.sesame.testing.evolutionary.SESAMEEvaluationProblemBase;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.StreamSetupFailed;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class SESAMEEvaluationProblemDistributed extends SESAMEEvaluationProblemBase {

	public SESAMEEvaluationProblemDistributed(String orchestratorBasePath, SESAMEModelLoader loader,
			String spaceModelFileName, Resource testingSpaceModel, TestingSpace testingSpace,
			Optional<TestCampaign> tc_o, String codeGenerationDirectory, boolean conditionBased, int conditionDepth,
			String grammarPath)
			throws InvalidTestCampaign, StreamSetupFailed, EolModelLoadingException, MissingGrammarFile {
			super(orchestratorBasePath, loader, spaceModelFileName, testingSpaceModel, testingSpace, tc_o, codeGenerationDirectory,
				conditionBased, conditionDepth, grammarPath);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void evaluate(SESAMETestSolution solution) {
		// Evaluate is a null since multiple solutions are evaluated in parallel
	}

	@Override
	public void shutDownMetricListener() {
		// Metric consumers are shut down in RemoteMetricMonitor
	}

	// ensureFinalModelSaved inherited from superclass - Ensures the final model is saved
	// This needs to be done for distributed too, to ensure the final result sets are saved!
}
