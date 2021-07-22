package uk.ac.york.sesame.testing.generator;

import org.eclipse.jface.wizard.Wizard;

public class SesameWizard extends Wizard {

	protected SesameWizardPage page;
	private UpdateProjectHandlerExecutor host;
	private String defaulturl;

	public SesameWizard(UpdateProjectHandlerExecutor updateProjectHandlerExecutor, String defaulturl) {
		super();
		this.host = updateProjectHandlerExecutor;
		this.defaulturl = defaulturl;
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {
		return "Update Typhon Polystore URL";
	}

	@Override
	public void addPages() {
		page = new SesameWizardPage(defaulturl);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		host.setUrl(page.getURL());
		return true;
	}
}
