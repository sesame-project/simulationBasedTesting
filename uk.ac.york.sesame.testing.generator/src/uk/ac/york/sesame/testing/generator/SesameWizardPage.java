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

	private Text testingModelLocation, mrsModelLocation;
	private Composite container;

	public SesameWizardPage() {
		super("Provide model locations");
		setTitle("Provide model locations");
		setControl(testingModelLocation);
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
				if (!testingModelLocation.getText().isEmpty() && !mrsModelLocation.getText().isEmpty())
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

		Label label2 = new Label(container, SWT.NONE);
		label2.setText("MRS Model:");
		mrsModelLocation = new Text(container, SWT.BORDER | SWT.SINGLE);
		mrsModelLocation.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!testingModelLocation.getText().isEmpty() && !mrsModelLocation.getText().isEmpty())
					setPageComplete(true);
				else
					setPageComplete(false);
			}

		});
		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleBrowse(mrsModelLocation);
			}
		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		testingModelLocation.setLayoutData(gd);
		mrsModelLocation.setLayoutData(gd);
		// required to avoid an error in the system
		setControl(container);
		//
		setPageComplete(testingModelLocation.getText().length() > 0 && mrsModelLocation.getText().length() > 0);
	}

	public String getTestModelLocation() {
		return testingModelLocation.getText();
	}
	
	public String getMRSModelLocation() {
		return mrsModelLocation.getText();
	}

	protected void handleBrowse(Text textfield) {
//		FileDialog dialog = new FileDialog(getShell());
//		dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().toString());
//		dialog.open();
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
				textfield.setText(((File) result[0]).getLocation().makeAbsolute().toOSString());
				setPageComplete(testingModelLocation.getText().length() > 0 && mrsModelLocation.getText().length() > 0);
		}
	}

}
