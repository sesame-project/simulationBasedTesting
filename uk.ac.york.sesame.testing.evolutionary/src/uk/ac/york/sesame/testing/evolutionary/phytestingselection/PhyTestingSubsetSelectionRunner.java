package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;

public class PhyTestingSubsetSelectionRunner {

	public static void main(String[] args) {
		String fileName = "/home/jharbin/eclipse-workspace-sesame/TTSTestProject/models/results/testingTTS-physubsettest.model";
		PhyTestingSubsetSelection nullTestPhysub = new PhyTestingSubsetSelection(new NullDimensionSetReducer(), 
																		 new NullMetricQualityValue());
		
		
		try {
			nullTestPhysub.loadModelToResults(fileName, "firstExperiment");
		} catch (EolModelLoadingException | InvalidTestCampaign e) {
			e.printStackTrace();
		}
	}
}
