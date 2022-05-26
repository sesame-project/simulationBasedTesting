package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.types.EolAnyType;

public class SESAMEEGLExecutor {

	private String testingModelPath;
	private String mrsModelPath;
		
	private String codeOutputPath = "/tmp/codegenerationPath/";
	
	public SESAMEEGLExecutor(String testingModelPath, String mrsModelPath) {
		this.testingModelPath = testingModelPath;
		this.mrsModelPath = mrsModelPath;
	}
	
	protected static ArrayList<String> registerMMs() throws IOException, UnknownPath {

		System.out.println("CURRENT USER.DIR = " + System.getProperty("user.dir"));
		ArrayList<String> mmURIs = new ArrayList<String>();
		Resource.Factory xmiFactory = new XMIResourceFactoryImpl();

		String modelPath = PathDefinitions.getPath(PathDefinitions.PathSpec.MODEL_PATH);

		Resource mrsMM = xmiFactory.createResource(URI.createFileURI(modelPath + "ExSceMM.ecore"));
		mrsMM.load(null);
		EPackage pkgMRS = (EPackage) mrsMM.getContents().get(0);
		EPackage.Registry.INSTANCE.put(pkgMRS.getNsURI(), pkgMRS);
		mmURIs.add(pkgMRS.getNsURI());

		Resource testingMM = xmiFactory.createResource(URI.createFileURI(modelPath + "TestingMM.ecore"));
		testingMM.load(null);

		TreeIterator<EObject> allContents = testingMM.getAllContents();
		while (allContents.hasNext()) {
			EObject element = allContents.next();
			System.out.println("The Element: " + element);

			if (element.eClass().getName().equals("EPackage")) {
				EPackage.Registry.INSTANCE.put(((EPackage) element).getNsURI(), element);
				mmURIs.add(((EPackage) element).getNsURI());
			}
		}
		
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

	public void run() {
		try {
			registerMMs();
			EmfModel mrsModel = createAndLoadAnEmfModel("http://ExSceMM", this.mrsModelPath, "MRS", "true", "true");
			EmfModel testingModel = createAndLoadAnEmfModel("TestingMM", this.testingModelPath, "Testing", "true","true");

			// EGX
			// Create the standalone EgxModule
			// https://www.eclipse.org/epsilon/doc/articles/code-generation-tutorial-egl/
			EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
			EgxModule egxModule = new EgxModule(factory);

			egxModule.getContext().getFrameStack().put(new Variable("path", codeOutputPath, new EolAnyType()));
			java.net.URI EgxFile = new File("files/orchestrator.egx").toURI();
			
			System.out.println(EgxFile);
			try {
				egxModule.parse(EgxFile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			factory.setOutputRoot(new File(codeOutputPath).toURI().toString());
			egxModule.getContext().getModelRepository().addModel(mrsModel);
			egxModule.getContext().getModelRepository().addModel(testingModel);
			egxModule.execute();

			// EGX END

			// JRH: shouldn't need to create a new generator if we have produced the code locally within this project
			
//			File pomfile = new File(theIProjectPath + "/pom.xml");
//			if (!pomfile.exists()) {
//				pomfile.createNewFile();
//				// System.out.println(pomfile.getAbsolutePath());
//				FileWriter fw2 = new FileWriter(pomfile);
//				fw2.write(DefaultPOM.contents());
//				fw2.close();
//
//				try {
//					//UtilityMethods.refresh(theIProject);
//				} catch (CoreException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("project pom updated, please run an update in maven if needed.");
//			}

		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnknownPath e2) {
			e2.printStackTrace();
		} finally {
		}
	}
}