package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.buildobjects.process.ProcResult;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;
import uk.ac.york.sesame.testing.architecture.utilities.ExptHelperWindows;

public class TestRunnerUtils {
	public enum OperatingSystem {
		OS_LINUX,
		OS_WINDOWS,
	}
	
    public static String ABS_SCRIPT_DIR = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
    public static boolean USE_MAVEN_COMPILATION = false;
    public static boolean USE_MAVEN_EXECUTION = false;

    public static Optional<OperatingSystem> detectOS() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			return Optional.of(OperatingSystem.OS_WINDOWS);
		}
		
		if (osName.contains("Linux")) {
			return Optional.of(OperatingSystem.OS_LINUX);
		}
		
		// Unknown OS
		return Optional.empty(); 
    }

    public static void execWindows(String mainClass, String codeGenerationDir) throws IOException {
		String workingDir = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		// Change to using batch file
		//String cmdLine = "~/source/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/execute_w.bat";
		String cmdLine = "C:\\cygwin64\\home\\James\\academic\\sesame\\WP6\\simulationBasedTesting\\uk.ac.york.sesame.testing.evolutionary\\scripts\\execute_windows.bat";
		String args [] = { mainClass, codeGenerationDir };
		Optional<ProcResult> res_o = ExptHelperWindows.runBatchFile(cmdLine, workingDir, args);
		
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Compilation output" + output);
		} else {
			System.out.println("Nothing returned from execWindows process result");
		}
		
	}
    
	public static void execLinux(String mainClass, String codeGenerationDir) throws IOException {
		ExptHelper.startCmd(ABS_SCRIPT_DIR, "./execute_testrunner_xterm.sh " +  mainClass + " " + codeGenerationDir);
	}
	
//	private static void mavenExecution(String mainClass, String codeGenerationDir) {
//		//String PROJECT_DIR = PathDefinitions.getPath
//		MavenCli cli = new MavenCli();
//		String projectDirectory = codeGenerationDir;
//		// TODO: need to customise the classpath here?
//		System.out.println("Starting Maven Execution...");
//		cli.doMain(new String[] { "exec:java", "-Dexec.mainClass=\"" + mainClass + "\""}, projectDirectory, System.out, System.err);
//		System.out.println("Maven Execution Done...");
//	}
		
	public static void exec(String mainClass, String codeGenerationDir) throws IOException {
		if (USE_MAVEN_EXECUTION) {
			//mavenExecution(mainClass, codeGenerationDir);
		} else {
			Optional<OperatingSystem> os_o = detectOS();
			if (os_o.isPresent()) {
				OperatingSystem os = os_o.get();
				if (os == OperatingSystem.OS_WINDOWS) {
					execWindows(mainClass, codeGenerationDir);
				}
				
				if (os == OperatingSystem.OS_LINUX) {
					execLinux(mainClass, codeGenerationDir);
				}	
			}	
		}
	}
	
	public static void compileProjectScriptWindows(String projectDir) throws IOException {
		String workingDir = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		String cmdLine = "~/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/compile_project_windows.sh";
		Optional<ProcResult> res_o = ExptHelperWindows.runViaCygwinBash(cmdLine, workingDir, projectDir);
		
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Compilation output" + output);
		} else {
			
		}
	}

	public static void compileProjectScriptLinux(String projectDir) throws IOException {
		// original script launcher
		//ExptHelper.startCmd(ABS_SCRIPT_DIR, "./compile_project_xterm.sh " + projectDir);
		
		// new script launcher to run the compilation in the main process
		String [] cmdArgs = {"-c", "/bin/ls.exe -l"};
		
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(ABS_SCRIPT_DIR, "c:\\cygwin64\\bin\\bash compile_project.sh", projectDir);
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Compilation output" + output);
		} else {
			
		}
	}
	
//	public static void printDependencyTreeCustom(MavenCli cli, String projectDir, String customStr) {
////		cli.doMain(new String [] { "dependency:tree"}, projectDir, System.out, System.err);
//	}
	
	public static void compileProjectMaven(String projectDir) throws IOException {
		// Use MavenCLI to perform the compilation here
//		MavenCli cli = new MavenCli();
//		String invokerDirectory = projectDir;
//		System.setProperty("maven.multiModuleProjectDirectory", projectDir);
//		printDependencyTreeCustom(cli, projectDir, "aether");		
//		System.out.println("Maven compilation starting...");
//		cli.doMain(new String [] { "compile" }, projectDir, System.out, System.err);
//		System.out.println("Maven compilation done");
	}
	
	public static void compileProject(String projectDir) throws IOException {
		if (USE_MAVEN_COMPILATION) {
			// Maven is cross-platform so should work with either
			compileProjectMaven(projectDir);
		} else {
			Optional<OperatingSystem> os_o = detectOS();
			if (os_o.isPresent()) {
				OperatingSystem os = os_o.get();
				if (os == OperatingSystem.OS_WINDOWS) {
					compileProjectScriptWindows(projectDir);
				}
				
				if (os == OperatingSystem.OS_LINUX) {
					compileProjectScriptLinux(projectDir);
				}	
			}
		}
	}

	public static void killProcesses() {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./terminate_sim.sh");
	}
	
	public static void runCustomTerminateScript(String terminateScript) {
		try {
			ExptHelper.runScriptNew(ABS_SCRIPT_DIR, terminateScript);
		} catch (org.buildobjects.process.ExternalProcessFailureException e) {
			System.out.println("Ignoring failure of the termination script");
		}
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

	public static void recordSim(String recordLauncher, String fileIDName) {
		Path p = Paths.get(recordLauncher);
		String parentDir = p.getParent().toString();
		ExptHelper.runScriptNewThread(parentDir, recordLauncher + " " + fileIDName);
	}
}
