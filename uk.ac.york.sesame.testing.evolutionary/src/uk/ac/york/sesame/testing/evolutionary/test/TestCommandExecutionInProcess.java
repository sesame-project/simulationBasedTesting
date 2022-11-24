package uk.ac.york.sesame.testing.evolutionary.test;

import java.util.Optional;

import org.buildobjects.process.ProcResult;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;
import uk.ac.york.sesame.testing.evolutionary.utilities.PathDefinitions;

public class TestCommandExecutionInProcess {
	
	public static void main(String [] args) {
		String ABS_SCRIPT_DIR = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		
		//ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./compile_project.sh " + projectDir);
		
		String [] cmdArgs = {"ARG1TEST", "/home/jharbin"};
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(ABS_SCRIPT_DIR, "./ls_dir.sh", cmdArgs);
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Generated output:" + output);
		} else {
			System.out.println("Command FAILED");
		}
	}
}
