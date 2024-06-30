package uk.ac.york.sesame.testing.evolutionary.test;

import java.util.Optional;

import org.buildobjects.process.ProcResult;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingPropertiesFile;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingProperty;
import uk.ac.york.sesame.testing.evolutionary.utilities.PathLookupFromProperties;

public class TestCommandExecutionInProcess {
	
	public static void main(String [] args) {
		try {
			String ABS_SCRIPT_DIR = PathLookupFromProperties.getProperty(PathLookupFromProperties.PathSpec.LOCAL_AUTO_RUNNER_SCRIPTS_DIR);
			String [] cmdArgs = {"ARG1TEST", "/home/jharbin"};
			Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(ABS_SCRIPT_DIR, "./ls_dir.sh", cmdArgs);
			if (res_o.isPresent()) {
				ProcResult res = res_o.get();
				String output = res.getOutputString();
				System.out.println("Generated output:" + output);
			} else {
				System.out.println("Command FAILED");
			}
		} catch (MissingProperty e) {
			e.printStackTrace();
		} catch (MissingPropertiesFile e) {
			e.printStackTrace();
		}
	}
}
