package uk.ac.york.sesame.testing.generator;

import java.util.Optional;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class UpdateProjectHandler implements IHandler {

	private enum OperatingSystem {
		OS_LINUX,
		OS_WINDOWS,
	}
	
	private String theIProjectPath;
	private IProject theIProject;

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
    private static Optional<OperatingSystem> detectOS() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			return Optional.of(OperatingSystem.OS_WINDOWS);
		}
		
		if (osName.contains("Linux")) {
			return Optional.of(OperatingSystem.OS_LINUX);
		}
		
		// Unknown OS
		return Optional.empty(); 
    }

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!isIProject(event)) {
			MessageDialog.openError(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error", "Not a project.");
			return null;
		}

		try {
			IRunnableWithProgress op = new UpdateProjectHandlerExecutor(theIProject, theIProjectPath, event);
			Optional<OperatingSystem> os_o = detectOS();
			if ((os_o).isPresent()) { 
				OperatingSystem os = os_o.get();
				boolean ranWizard = false;
				if (os == OperatingSystem.OS_WINDOWS) {
					// JRH: for some reason, under Windows the wizard hangs before allowing the user
					// to select the paths properly, maybe because Windows handles a modal dialog box
					// differently. Therefore, use a different application window type on Windows. 
					// This may work fine on Linux too, but for now, Linux still uses the old way
					new ApplicationWindow(HandlerUtil.getActiveWorkbenchWindow(event).getShell()).run(true, true, op);
					ranWizard = true;
				}
				
				if (os == OperatingSystem.OS_LINUX) {
					new ProgressMonitorDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell()).run(true, true, op);
					ranWizard = true;
				}
				
				if (!ranWizard) {
					System.out.println("Could not detect OS in order to run SESAME wizard");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private boolean isIProject(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection instanceof ITreeSelection) {
			theIProject = (IProject) ((IAdaptable) ((TreeSelection) selection).getPaths()[0].getFirstSegment())
					.getAdapter(IProject.class);
			if (theIProject != null)
				theIProjectPath = theIProject.getProject().getLocation().toOSString();
			return theIProject != null;
		}
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
