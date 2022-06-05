package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.IOException;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;

public class TestRunnerUtils {
	static final String ABS_SCRIPT_DIR = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.evolutionary/scripts/";
	
	public static void exec(String mainClass) throws IOException {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./execute_testrunner_xterm.sh", mainClass);
	}

	public static void compileProject(String projectDir) {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./compile_project.sh", projectDir);
	}
}
