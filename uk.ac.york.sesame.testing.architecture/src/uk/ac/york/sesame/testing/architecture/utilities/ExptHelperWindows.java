package uk.ac.york.sesame.testing.architecture.utilities;

import java.util.Optional;
import org.buildobjects.process.ProcResult;

public class ExptHelperWindows {
	public static Optional<ProcResult> runViaCygwinBash(String cmdLine, String workingDir, String arg) {
		String osName = System.getProperty("os.name");
		System.out.println("osName = " + osName);

		String[] cmdArgs = { "-l", cmdLine,  arg};
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
