package uk.ac.york.sesame.testing.generator;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.FileSelectionDialog;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.internal.ide.dialogs.FileFolderSelectionDialog;

public class SesameWizardPage extends WizardPage {

	private Text testingModelLocation;
	private Text codeGenerationDirectory;
	private Text orchestratorBasePath;
	
	//mrsModelLocation;
	private Composite container;

	public SesameWizardPage() {
		super("Provide model locations");
		setTitle("Provide model locations");
		setControl(testingModelLocation);
	}
	
	private boolean isWizardComplete() {
		boolean isComplete = (testingModelLocation.getText().length() > 0);
		isComplete = isComplete && (codeGenerationDirectory.getText().length() > 0);
		isComplete = isComplete && (orchestratorBasePath.getText().length() > 0);
		return isComplete; 
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Testing Model:");

		testingModelLocation = new Text(container, SWT.BORDER | SWT.SINGLE);
		testingModelLocation.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!testingModelLocation.getText().isEmpty())
					setPageComplete(true);
				else
					setPageComplete(false);
			}

		});
		Button button2 = new Button(container, SWT.PUSH);
		button2.setText("Browse...");
		button2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleBrowse(testingModelLocation);
			}
		});

		//////////////////////////////////////////////////////////////////////////////////
		// Code generation directory
		Label label2 = new Label(container, SWT.NONE);
		label2.setText("Code Generation Directory:");
		codeGenerationDirectory = new Text(container, SWT.BORDER | SWT.SINGLE);
		codeGenerationDirectory.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO: are all these ready
				if (isWizardComplete())
					setPageComplete(true);
				else
					setPageComplete(false);
			}

		});
		
		//////////////////////////////////////////////////////////////////////////////////
		// orchestratorBasePath
		Label label3 = new Label(container, SWT.NONE);
		label3.setText("Orchestrator Base Path:");
		orchestratorBasePath = new Text(container, SWT.BORDER | SWT.SINGLE);
		codeGenerationDirectory.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO: are all these ready
				if (isWizardComplete())
					setPageComplete(true);
				else
					setPageComplete(false);
			}
		});	

		setPageComplete(isWizardComplete());
	}

	public String getTestModelLocation() {
		return testingModelLocation.getText();
	}
	
//	public String getMRSModelLocation() {
//		return mrsModelLocation.getText();
//	}

	protected void handleBrowse(Text textfield) {
//		FileDialog dialog = new FileDialog(getShell());
//		dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().toString());
//		dialog.open();
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
				textfield.setText(((File) result[0]).getLocation().makeAbsolute().toOSString());
				//setPageComplete(testingModelLocation.getText().length() > 0 && mrsModelLocation.getText().length() > 0);
				setPageComplete(testingModelLocation.getText().length() > 0);
		}
	}
}
