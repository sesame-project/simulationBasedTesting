package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.File;
import java.util.Optional;

import org.buildobjects.process.ProcResult;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelperWindows;

public class TestKillProcesses {
	
	private static void killProcessesWindows() {
		String workingDir = PathDefinitions.getPath(PathDefinitions.PathSpec.AUTO_RUNNER_SCRIPTS);
		String cmdLine = "~/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/terminate_sim_windows.sh";
		Optional<ProcResult> res_o = ExptHelperWindows.runViaCygwinBash(cmdLine, workingDir, "");
		
		if (res_o.isPresent()) {
			ProcResult res = res_o.get();
			String output = res.getOutputString();
			System.out.println("Kill Process output:" + output);
		} else {
			
		}
	}
	
	public static void main(String [] args) {
		killProcessesWindows();
		System.out.println("Kill processes Windows done");
	}
}
