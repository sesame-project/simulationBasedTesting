package uk.ac.york.sesame.testing.evolutionary.test;

import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;

public class TestCodeGeneration {
	public static void test1(String[] args) {
		String __mrsModelFile = "testingMRS.model";
		String spaceModelFileName = "/home/jharbin/eclipse-workspace/localAutoGen/models/testingHealthcareSpace.model";
		String campaignName = "firstExperiment";
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/eclipse-workspace/localAutoGen/";
		
		SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName, CODE_GENERATION_DIRECTORY);
		System.out.println("eglEx - executor created");
		eglEx.run();
		System.out.println("eglEx - executor ran");
	}
	
	public static void main(String[] args) {
		test1(args);
	}
}
