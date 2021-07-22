package uk.ac.york.sesame.testing.generator;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class UpdateProjectHandlerExecutor implements IRunnableWithProgress {

	private ExecutionEvent event;
	private String theIProjectPath;
	private IProject theIProject;
	private String url;

	public UpdateProjectHandlerExecutor(IProject theIProject, String theIProjectPath, ExecutionEvent event) {
		this.event = event;
		this.theIProject = theIProject;
		this.theIProjectPath = theIProjectPath;
	}

	@Override
	public void run(IProgressMonitor pm) throws InvocationTargetException, InterruptedException {

		File tmlfile = null;
		try {

			UtilityMethods.refresh(theIProject);
			System.out.println("entities generated successfully.");

			//

			File pomfile = new File(theIProjectPath + "/pom.xml");
			if (!pomfile.exists()) {
				pomfile.createNewFile();
				// System.out.println(pomfile.getAbsolutePath());
				FileWriter fw2 = new FileWriter(pomfile);
				fw2.write(DefaultPOM.contents());
				fw2.close();

				UtilityMethods.refresh(theIProject);
				System.out.println("project pom updated, please run an update in maven if needed.");
			}
			
			File propertiesFile = new File(theIProjectPath + "/resources/typhonAnalyticsConfig.properties");
			if (!propertiesFile.exists()) {
				File dirs = new File(theIProjectPath + "/resources/");
				dirs.mkdirs();						
				propertiesFile.createNewFile();
				// System.out.println(pomfile.getAbsolutePath());
				FileWriter fw2 = new FileWriter(propertiesFile);
				fw2.write(DefaultAnalyticsProperties.contents());
				fw2.close();

				UtilityMethods.refresh(theIProject);
				System.out.println("properties file updated.");
			}

			File defaultanalyticsrunner = new File(theIProjectPath + "/src/analytics/DefaultAnalyticsRunner.java");
			if (!defaultanalyticsrunner.exists()) {
				File dirs = new File(theIProjectPath + "/src/analytics/");
				dirs.mkdirs();						
				defaultanalyticsrunner.createNewFile();
				FileWriter fw2 = new FileWriter(defaultanalyticsrunner);
				fw2.write(DefaultAnalyticsRunner.contents());
				fw2.close();

				UtilityMethods.refresh(theIProject);
			}

		} catch (Exception ex) {
			LogUtil.log(ex);
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					MessageDialog.openError(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Error",
							"An error has occured. Please see the Error Log.");
				}
			});
		} finally {
			try {
				tmlfile.delete();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

}
