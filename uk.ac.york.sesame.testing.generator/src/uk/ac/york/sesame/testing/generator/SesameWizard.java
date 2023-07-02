package uk.ac.york.sesame.testing.generator;

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
		
		wizardExecutor.setOrchestratorBasePath(page.getOrchestratorBasePath());
		wizardExecutor.setOrchestratorPath("files/orchestratorFirstPhase.egx");
		wizardExecutor.setTestingModelPath(page.getTestModelLocation());
		wizardExecutor.setCodeGenerationDirectory(page.getCodeGenerationDirectory());
		
		return true;
	}
}
