package uk.ac.york.sesame.testing.evolutionary.distributed;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionTarget;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class SOPRANODistributedExperiment {
	public boolean isActive = true;
	private TestCampaign selectedCampaign;
	private SESAMEModelLoader loader;
	
	private String orchestratorBasePath;
	private String spaceModelFilename;
	
	// TODO: configurable shared directory
	private String SHARED_CODE_DIRECTORY = "/samba/shared-soprano-code/";
	
	public SOPRANODistributedExperiment(TestCampaign selectedCampaign, SESAMEModelLoader loader, String orchestratorBasePath, String spaceModelFilename) {
		this.selectedCampaign = selectedCampaign;
		this.loader = loader;
		this.spaceModelFilename = spaceModelFilename;
		this.orchestratorBasePath = orchestratorBasePath;
	}

	public boolean isActive() {
		return isActive;
	}

	public void synchroniseFiles() {
		// TODO Auto-generated method stub
		
	}

	public boolean isCompleted() {
		return !isActive;
	}
	
	public void setCompleted() {
		isActive = false;
	}
	
	public TestCampaign getCampaign() {
		return selectedCampaign;
	}
	
	public synchronized void generateAllCode() {
		//String mainClassName = solution.getMainClassName();
		String campaignName = selectedCampaign.getName();
		
		// TODO: do we need a proper separation of the MRS models now?
		String __mrsModelFile = "testingMRS.model";
		
		String codeGenerationDirectory = SHARED_CODE_DIRECTORY;
		
		System.out.println("Generating code for project in: " + codeGenerationDirectory);
		// This ensures that the new test is installed in the model


		loader.saveTestingSpace();
		// THIS is a temporary change to test if caching is causing the model to be
		// stale for EGL???
		// String novelModelFile = "/tmp/testingspace-updated-after-" + mainClassName +
		// ".model";
		// loader.saveTestingSpaceToNewFile(novelModelFile);
		System.out.println("Model updated");

		System.out.print("Waiting to begin code generation...");
		System.out.flush();

		SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(orchestratorBasePath, spaceModelFilename, __mrsModelFile, campaignName, codeGenerationDirectory);
		eglEx.run();
	}
	
	public synchronized void saveModel() {
		loader.saveTestingSpace();
	}
}
