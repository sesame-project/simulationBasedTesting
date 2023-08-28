package uk.ac.york.sesame.testing.standalone.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class StandaloneGeneratorFirstPhase {

	// ARGS /////////////////////////////////////////////////////////////////////////////////////////////////
	// arg 1 - REPO_BASE - this is the root at which you checked out the Github SMB repository
	// e.g. "/home/jharbin/academic/sesame/WP6/";
	private static String REPO_BASE;
	//
	// arg 2 - testingModelPath - this is the testing model file you want to use to generate code from
	// e.g. "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.standalone.generator/models/testingKUKA_TTS.model";
	private static String testingModelPath;
	//
	// arg 3 - codeGenerationDirectory:
	// This is the output directory for generated Java code (for metrics and experiment runners) to be placed
	// Here we generate into a test project: StandaloneGenTest - which should be created as a 
	// Java project in the standard Eclipse workspace
	// e.g. "/home/jharbin/eclipse-workspace/StandaloneGenTest";
	private static String codeGenerationDirectory;
	//	
	/////////////////////////////////////////////////////////
	private static String generatorProjectPath;
	private static String metamodelDirectory;
	
	////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * registerMetamodel - this ensures the given metamodel (in the
	 * metamodelDirectory) is registered
	 */
	protected static ArrayList<String> registerMetamodel(String metamodelName) throws IOException {
		ArrayList<String> mmURIs = new ArrayList<String>();
		Resource.Factory xmiFactory = new XMIResourceFactoryImpl();

		Resource testingMM = xmiFactory
				.createResource(URI.createFileURI(metamodelDirectory + "/" + metamodelName + ".ecore"));
		testingMM.load(null);

		TreeIterator<EObject> allContents = testingMM.getAllContents();
		while (allContents.hasNext()) {
			EObject element = allContents.next();
			if (element.eClass().getName().equals("EPackage")) {
				EPackage.Registry.INSTANCE.put(((EPackage) element).getNsURI(), element);
				mmURIs.add(((EPackage) element).getNsURI());
			}
		}

		return mmURIs;
	}
	
	/* loadsEMFModel - loads the given EMF model with the given metamodel
	 */
	private static EmfModel loadEMFModel(String metaModelName, String testingModelFilePath, String modelName)
			throws EolModelLoadingException {
		EmfModel model = new EmfModel();
		String metaModelFilePath = metamodelDirectory + "/" + metaModelName + ".ecore";
		ArrayList<String> metamodelFilesTarget = new ArrayList<String>();
		System.out.println("Metamodel file path = " + new File(metaModelFilePath).getAbsolutePath());
		metamodelFilesTarget.add(new File(metaModelFilePath).getAbsolutePath());
		model.setMetamodelFiles(metamodelFilesTarget);
		model.setName(modelName);
		model.setModelFile(testingModelFilePath);
		model.setStoredOnDisposal(true);
		model.load();
		return model;
	}

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("3 arguments needed, repo base, model path, code generation dir");
		} else {
			REPO_BASE = args[0];
			testingModelPath = args[1];
			codeGenerationDirectory = args[2];
			generatorProjectPath = REPO_BASE + "uk.ac.york.sesame.testing.generator/";
			metamodelDirectory = REPO_BASE + "uk.ac.york.sesame.testing.dsl/models";
			generateCode();
		}
	}
	
	public static void generateCode() {
					
		try {
			// Load the EMF model and metamodel
			EmfModel testingModel = loadEMFModel("TestingMM", testingModelPath, "Testing");
			System.out.println("Model " + testingModelPath + " loaded successfully");

			// Create the standalone EgxModule
			EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
			EgxModule egxModule = new EgxModule(factory);	
			System.out.println("EGX module created successfully");

			// This sets parameters that the EGX generator passes to the other EGL generators
			egxModule.getContext().getFrameStack()
					.put((Variable.createReadOnlyVariable("testingModelPath", testingModelPath)));
			egxModule.getContext().getFrameStack()
					.put((Variable.createReadOnlyVariable("codeGenerationDirectory", codeGenerationDirectory)));
			egxModule.getContext().getFrameStack()
					.put((Variable.createReadOnlyVariable("orchestratorBasePath", generatorProjectPath)));

			// Now begin code generation
			String orchestratorPath = "files/orchestratorFirstPhase.egx";
			String orchestratorFile = generatorProjectPath + "/" + orchestratorPath;
			java.net.URI EgxFile = new File(orchestratorFile).toURI();

			try {
				System.out.println("Parsing EGX file at " + EgxFile);
				egxModule.parse(EgxFile);
				factory.setOutputRoot(new File(codeGenerationDirectory).toURI().toString());
				egxModule.getContext().getModelRepository().addModel(testingModel);
				egxModule.execute();
			} catch (EolRuntimeException e) {
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Code generation completed successfully!");
		}
	}
}