package uk.ac.york.sesame.testing.evolutionary.test;

import java.util.Optional;

import org.buildobjects.process.ProcResult;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;
import uk.ac.york.sesame.testing.evolutionary.utilities.PathDefinitions;

public class TestProcessLaunchWindowsScript {
	
	public static void main(String [] args) {
		
		String osName = System.getProperty("os.name");
		System.out.println("osName = " + osName);
		
		String ABS_SCRIPT_DIR = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		
		//ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./compile_project.sh " + projectDir);
		
		String [] cmdArgs = {"-l", "/home/James/source/ls_dir.sh", "ARGTEST", "/home/James"};
		//Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(ABS_SCRIPT_DIR, "set PATH=C:\\cygwin64\\bin;%PATH% && c:\\cygwin64\\bin\\bash.exe /home/James/source/ls_dir.sh", cmdArgs);
		
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(ABS_SCRIPT_DIR, "c:\\cygwin64\\bin\\bash.exe", cmdArgs);

		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Generated output:" + output);
		} else {
			System.out.println("Command FAILED");
		}
	}
}
