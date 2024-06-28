package uk.ac.york.sesame.testing.generator;

import java.io.File;
import java.util.Optional;

import org.eclipse.jface.wizard.Wizard;

public class SesameWizard extends Wizard {

	protected SesameWizardPage page;
	private UpdateProjectHandlerExecutor wizardExecutor;
	private String defaulturl;

	public SesameWizard(UpdateProjectHandlerExecutor updateProjectHandlerExecutor) {
		super();
		this.wizardExecutor = updateProjectHandlerExecutor;
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {
		return "Provide Test and MRS Models";
	}

	@Override
	public void addPages() {
		page = new SesameWizardPage();
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		//wizardExecutor.setMrsModelPath(page.getMRSModelLocation());
		
        Optional<File> repoBaseDir_o = DiscoverPaths.findRepoBase();
        if (repoBaseDir_o.isPresent()) {
        	File repoBaseDir = repoBaseDir_o.get();
            File genProject = DiscoverPaths.findGeneratorProject(repoBaseDir);
            String genProjectPath = genProject.getAbsolutePath();
            System.out.println("Generator project base path: " + genProject.getAbsolutePath());
        		
            wizardExecutor.setOrchestratorBasePath(genProjectPath);
            wizardExecutor.setOrchestratorPath("files/orchestratorFirstPhase.egx");
            wizardExecutor.setTestingModelPath(page.getTestModelLocation());
            wizardExecutor.setCodeGenerationDirectory(page.getCodeGenerationDirectory());
        }
		
		return true;
	}
}
