package uk.ac.york.sesame.testing.evolutionary.distributed;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ContainerDependency;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.Dependency;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.DistributedExecutionStrategy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class SOPRANODistributedExperiment {
	public boolean isActive = true;
	private TestCampaign selectedCampaign;
	//private MRS mrs;
	private DistributedExecutionStrategy dexecStrat;
	private SESAMEModelLoader loader;
	
	private String orchestratorBasePath;
	private String spaceModelFilename;
	
	// TODO: configurable shared directory
	private String SHARED_CODE_DIRECTORY = "/samba/shared-soprano-code/";
	
	public SOPRANODistributedExperiment(TestCampaign selectedCampaign, DistributedExecutionStrategy dexecStrat, SESAMEModelLoader loader, String orchestratorBasePath, String spaceModelFilename) {
		this.selectedCampaign = selectedCampaign;
		this.loader = loader;
		this.spaceModelFilename = spaceModelFilename;
		this.orchestratorBasePath = orchestratorBasePath;
		this.dexecStrat = dexecStrat;
		
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
	
	/** Gets the dependencies as a map */
	public Map<String,List<String>> getDependencies() {
		EList<Dependency> depsDSL = dexecStrat.getDependencies();
		Map<String,List<String>> deps = new HashMap<String,List<String>>();
		for (Dependency d : depsDSL) {
			if (d instanceof ContainerDependency) {
				ContainerDependency cd = (ContainerDependency)d;
				String imageName = cd.getImageName();
				String containerTech = cd.getTech().toString();
				if (!deps.containsKey(containerTech)) {
					deps.put(containerTech, new ArrayList<String>());
				}
				
				deps.get(containerTech).add(imageName);
			}
		}
		return deps;
	}
	
	public synchronized void generateAllCode() {
		String campaignName = selectedCampaign.getName();
		
		// TODO: do we need a proper separation of the MRS models now?
		String __mrsModelFile = "testingMRS.model";
		
		String codeGenerationDirectory = SHARED_CODE_DIRECTORY;
		
		System.out.println("Generating code for project in: " + codeGenerationDirectory);
		// This ensures that the new test is installed in the model

		loader.saveTestingSpace();
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
