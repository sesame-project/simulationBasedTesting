package testAutoGen;

import uk.ac.york.sesame.testing.evolutionary.utilities.*;

public class TestCodeGeneration {
	public static void test1(String[] args) {
		String __mrsModelFile = "testingMRS.model";
		String spaceModelFileName = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.dsl/models/testingHealthcareSpace.model";
		String campaignName = "firstExperiment";
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/runtime-EclipseApplication/testAutoGen/";
		
		//SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName, CODE_GENERATION_DIRECTORY);
		System.out.println("eglEx - executor created");
		eglEx.run();
		System.out.println("eglEx - executor ran");
	}
	
	public static void main(String[] args) {
		test1(args);
	}
}