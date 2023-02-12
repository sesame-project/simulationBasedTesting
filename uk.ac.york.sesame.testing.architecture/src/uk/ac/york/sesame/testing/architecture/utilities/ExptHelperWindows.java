package uk.ac.york.sesame.testing.architecture.utilities;

import java.util.Optional;
import org.buildobjects.process.ProcResult;

public class ExptHelperWindows {

	public static Optional<ProcResult> runBatchFile(String cmdLine, String workingDir, String [] cmdArgs) {
		String osName = System.getProperty("os.name");
		System.out.println("osName = " + osName);
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(workingDir, cmdLine, cmdArgs);
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Generated output:" + output);
		} else {
			System.out.println("Command FAILED");
		}
		return res_o; 
	}
	
	public static Optional<ProcResult> runViaCygwinBash(String cmdLine, String workingDir) {
		String osName = System.getProperty("os.name");
		System.out.println("osName = " + osName);

		String[] cmdArgs = { "-l", cmdLine};
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(workingDir, "c:\\cygwin64\\bin\\bash.exe", cmdArgs);
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Generated output:" + output);
		} else {
			System.out.println("Command FAILED");
		}
		return res_o; 
	}
	
	public static Optional<ProcResult> runViaCygwinBash(String cmdLine, String workingDir, String args) {
		String osName = System.getProperty("os.name");
		System.out.println("osName = " + osName);
		String[] cmdArgs = { "-l", cmdLine,  args};
		
		// If nothing is supplied, just use a Windows path for the base
		// Cygwin dir
		if (workingDir.isEmpty()) {
			workingDir = "c:\\cygwin64\\bin\\";
		}
		
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(workingDir, "c:\\cygwin64\\bin\\bash.exe", cmdArgs);
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Generated output:" + output);
		} else {
			System.out.println("Command FAILED");
		}
		return res_o;
	}
	
	public static Optional<ProcResult> runViaCygwinBashWithCOpt(String cmdLine, String workingDir, String args) {
		String osName = System.getProperty("os.name");
		System.out.println("osName = " + osName);
		String[] cmdArgs = { "-l", "-c", cmdLine,  args};
		
		// If nothing is supplied, just use a Windows path for the base
		// Cygwin dir
		if (workingDir.isEmpty()) {
			workingDir = "c:\\cygwin64\\bin\\";
		}
		
		Optional<ProcResult> res_o = ExptHelper.runScriptWithArgs(workingDir, "c:\\cygwin64\\bin\\bash.exe", cmdArgs);
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Generated output:" + output);
		} else {
			System.out.println("Command FAILED");
		}
		return res_o;
	}
}
