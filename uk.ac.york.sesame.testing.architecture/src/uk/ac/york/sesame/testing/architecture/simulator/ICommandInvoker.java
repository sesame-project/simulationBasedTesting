package uk.ac.york.sesame.testing.architecture.simulator;

import java.util.Properties;

public interface ICommandInvoker {
	
	public Object invoke(String commandName, Properties params);

}
