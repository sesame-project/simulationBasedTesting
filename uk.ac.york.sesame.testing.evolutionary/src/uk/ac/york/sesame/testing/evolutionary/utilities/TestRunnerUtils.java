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
		ExptHelperWindows.runBatchFileNewThread(cmdLine, workingDir, args);
		System.out.println("Launched Windows process via batch file");
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
		ExptHelper.startCmd(ABS_SCRIPT_DIR, "./compile_project_xterm.sh " + projectDir);
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

	public static void killProcessesLinux() {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./terminate_sim.sh");
	}
	
	private static void killProcessesWindows() {
		String workingDir = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		String cmdLine = "~/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/terminate_sim_windows.sh";
		Optional<ProcResult> res_o = ExptHelperWindows.runViaCygwinBash(cmdLine, workingDir, "");
		
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Kill Process output" + output);
		} else {
			
		}
	}
	
	public static void killProcesses() {
		Optional<OperatingSystem> os_o = detectOS();
		if (os_o.isPresent()) {
			OperatingSystem os = os_o.get();
			if (os == OperatingSystem.OS_WINDOWS) {
				killProcessesWindows();
			}
			
			if (os == OperatingSystem.OS_LINUX) {
				killProcessesLinux();
			}	
		}
	}


	public static void runCustomTerminateScript(String terminateScript) {
		try {
			ExptHelper.runScriptNew(ABS_SCRIPT_DIR, terminateScript);
		} catch (org.buildobjects.process.ExternalProcessFailureException e) {
			System.out.println("Ignoring failure of the termination script");
		}
	}
	
	public static void clearKafka() {
		Optional<OperatingSystem> os_o = detectOS();
		if (os_o.isPresent()) {
			OperatingSystem os = os_o.get();
			if (os == OperatingSystem.OS_WINDOWS) {
				clearKafkaWindows();
			}
			
			if (os == OperatingSystem.OS_LINUX) {
			clearKafkaLinux();
			}	
		}
	}

	public static void clearKafkaWindows() {
		String workingDir = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		String cmdLine = "~/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/clear_kafka_windows.sh";
		Optional<ProcResult> res_o = ExptHelperWindows.runViaCygwinBash(cmdLine, workingDir, "");
		
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Clear Kafka output" + output);
		} else {
			
		}
		
//		String workingDir = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
//
//		String cmd = "wsl -u jharbin ~/clear_kafka.sh";
//		//String [] cmdArgs =  { "-u jharbin", " ~/clear_kafka.sh"};
//		String [] cmdArgs = {};
//		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(workingDir, cmd, cmdArgs);
//		
//		if (res_o.isPresent()) {
//			ProcResult res = res_o.get();
//			String output = res.getOutputString();
//			System.out.println("Clear kakfa call output: " + output);
//		} else {
//			
//		}
	}
	
	public static void clearKafkaLinux() {
		ExptHelper.runScriptNew(ABS_SCRIPT_DIR, "./clear_kafka.sh");
	}

	public static void waitForSeconds(double timeDelaySeconds) {
		long endTimeMillis = System.currentTimeMillis() + (long)((double)timeDelaySeconds * 1000);
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
