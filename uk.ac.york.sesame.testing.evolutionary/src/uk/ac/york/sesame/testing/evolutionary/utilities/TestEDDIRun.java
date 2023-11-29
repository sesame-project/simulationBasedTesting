package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.File;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelperWindows;

public class TestEDDIRun {
	public static void runExtraScriptIfExists(String workingDir, String testID, long extrasWaitdelayMsec) {
		String extrasFile = "start-extras.sh";
		String extrasPath = "C:\\cygwin64" + workingDir.replace("/", "\\") + "\\" + extrasFile;
		
		if ((new File(extrasPath)).exists()) {
			String cmdLine = "cd " + workingDir + " && ./" + extrasFile + " " + testID;
			ExptHelperWindows.runScriptNewThread("", cmdLine, "");
			
			// Need to wait the delay after the EDDI launched
			try {
				Thread.sleep(extrasWaitdelayMsec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Could not find extras script at " + extrasPath + " - ignoring");
		}
	}
	
	public static void main(String [] args) {
		runExtraScriptIfExists("/home/James/protocol-test/Proto_V3/dist", "TEST-001", 1000);
	}
}
