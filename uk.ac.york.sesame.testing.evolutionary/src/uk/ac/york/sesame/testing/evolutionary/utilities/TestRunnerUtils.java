package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.IOException;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;

public class TestRunnerUtils {
	// TODO: pull out path to some central place
	static final String ABS_SCRIPT_DIR = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.evolutionary/scripts/";

	public static void exec(String mainClass, String codeGenerationDir) throws IOException {
		//ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./execute_testrunner_xterm.sh", mainClass);
		ExptHelper.startCmd(ABS_SCRIPT_DIR, "./execute_testrunner_xterm.sh " + mainClass + " " + codeGenerationDir);
	}

	public static void compileProject(String projectDir) throws IOException {
		ExptHelper.startCmd(ABS_SCRIPT_DIR, "./compile_project_xterm.sh " + projectDir);
	}

	public static void killProcesses() {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./terminate_sim.sh");
	}
	
	public static void clearKafka() {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./clear_kafka.sh");
	}
	
	public static void __variableLogging(String mainClass) throws IOException {
		ExptHelper.runScriptNewWithBashTimeout(ABS_SCRIPT_DIR, "./log_topics.sh " + mainClass, 300);
	}

	public static void waitForSeconds(long timeDelaySeconds) {
		long endTimeMillis = System.currentTimeMillis() + timeDelaySeconds * 1000;
		while (System.currentTimeMillis() < endTimeMillis) {
			try {
				Thread.sleep(endTimeMillis - System.currentTimeMillis());
			} catch (InterruptedException e) {
				
			}
		}
	}
}
