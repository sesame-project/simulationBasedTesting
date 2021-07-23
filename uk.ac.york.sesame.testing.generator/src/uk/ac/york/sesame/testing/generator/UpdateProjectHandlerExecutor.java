package uk.ac.york.sesame.testing.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class UpdateProjectHandlerExecutor implements IRunnableWithProgress {

	private ExecutionEvent event;
	private String theIProjectPath;
	private IProject theIProject;
	private String testingModelPath;
	private String mrsModelPath;

	

	public UpdateProjectHandlerExecutor(IProject theIProject, String theIProjectPath, ExecutionEvent event) {
		this.event = event;
		this.theIProject = theIProject;
		this.theIProjectPath = theIProjectPath;
	}

	@Override
	public void run(IProgressMonitor pm) throws InvocationTargetException, InterruptedException {

		try {
			
			SesameWizard w = new SesameWizard(this);
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					WizardDialog dialog = new WizardDialog(shell, w);
					dialog.open();
				}
			});
			
			registerMMs();
			
			System.out.println("----- MRS: " + this.mrsModelPath + ", TEST: " + testingModelPath + "-----");
			
			//emf source (your mission model)
//			EmfModel sourceModelForEGL = createAndLoadAnEmfModel(
//					"http://www.github.com/jrharbin-york/atlas-middleware/dsl/mission,http://www.github.com/jrharbin-york/atlas-middleware/dsl/region,http://www.github.com/jrharbin-york/atlas-middleware/dsl/message,http://www.github.com/jrharbin-york/atlas-middleware/dsl/fuzzing,http://www.github.com/jrharbin-york/atlas-middleware/dsl/faults,http://www.github.com/jrharbin-york/atlas-middleware/dsl/components",
//					theFile.getRawLocation().toOSString(), "Source", "true", "true");
			EmfModel mrsModel = createAndLoadAnEmfModel("ExSceMM",this.mrsModelPath, "MRS", "true", "true");
			EmfModel testingModel = createAndLoadAnEmfModel("TestingMM",this.testingModelPath, "Testing", "true", "true");

			//egl factory and module
			EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
			EglTemplateFactoryModuleAdapter eglModule = new EglTemplateFactoryModuleAdapter(factory);
			eglModule.getContext().getModelRepository().addModel(mrsModel);
			eglModule.getContext().getModelRepository().addModel(testingModel);

			// Point to where the EGL file is located
			java.net.URI EglFile = Activator.getDefault().getBundle().getResource("files/testSuiteRunnerGenerator.egl").toURI();

			EglFileGeneratingTemplate template = (EglFileGeneratingTemplate) factory.load(EglFile);
			template.process();
			
			// Set the target file, ie. where the results will be generated to.
//			File target = new File(theFile.getRawLocation().removeFileExtension().toOSString() + "GeneratedFile.txt");
			File target = new File("/home/thanos/Documents/Workspaces/runtime-New_configuration/test/src/testingTestSuiteRunner.java");

			target.createNewFile();
			template.generate(target.toURI().toString());
			
			// !!! END OF EGL EXECUTION FROM JAVA !!!
			
			File pomfile = new File(theIProjectPath + "/pom.xml");
			if (!pomfile.exists()) {
				pomfile.createNewFile();
				// System.out.println(pomfile.getAbsolutePath());
				FileWriter fw2 = new FileWriter(pomfile);
				fw2.write(DefaultPOM.contents());
				fw2.close();

				try {
					UtilityMethods.refresh(theIProject);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("project pom updated, please run an update in maven if needed.");
			}
			
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}

	protected static ArrayList<String> registerMMs() throws IOException {

		ArrayList<String> mmURIs = new ArrayList<String>();
		Resource.Factory xmiFactory = new XMIResourceFactoryImpl();

		Resource mrsMM = xmiFactory.createResource(URI.createFileURI("/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceMM.ecore"));
		mrsMM.load(null);
		EPackage pkgMRS = (EPackage) mrsMM.getContents().get(0);
		EPackage.Registry.INSTANCE.put(pkgMRS.getNsURI(), pkgMRS);
		mmURIs.add(pkgMRS.getNsURI());

		Resource testingMM = xmiFactory.createResource(URI.createFileURI("/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/TestingMM.ecore"));
		testingMM.load(null);
		EPackage pkgTesting = (EPackage) testingMM.getContents().get(0);
		EPackage.Registry.INSTANCE.put(pkgTesting.getNsURI(), pkgTesting);
		mmURIs.add(pkgTesting.getNsURI());
		
		return mmURIs;
	}
	
	private EmfModel createAndLoadAnEmfModel(String metamodelURI, String modelFile, String modelName, String readOnLoad,
			String storeOnDisposal) throws EolModelLoadingException {
		EmfModel theModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelURI);
		properties.put(EmfModel.PROPERTY_MODEL_FILE, modelFile);
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad);
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, storeOnDisposal);
		//
		properties.put(EmfModel.PROPERTY_CACHED, "false");
		//
		theModel.load(properties, (IRelativePathResolver) null);
		return theModel;
	}
	
	public String getTestingModelPath() {
		return testingModelPath;
	}

	public void setTestingModelPath(String testingModelPath) {
		this.testingModelPath = testingModelPath;
	}

	public String getMrsModelPath() {
		return mrsModelPath;
	}

	public void setMrsModelPath(String mrsModelPath) {
		this.mrsModelPath = mrsModelPath;
	}
}
