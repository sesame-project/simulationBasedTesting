package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.FileWriter;
import java.io.IOException;

import org.uma.jmetal.operator.crossover.CrossoverOperator;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

abstract public class SESAMECrossoverOperation implements CrossoverOperator<SESAMETestSolution> {

	private static final long serialVersionUID = 1L;
	private FileWriter crossoverLog;

	SESAMECrossoverOperation(String crossoverLogFileName) throws IOException {
		this.crossoverLog = new FileWriter(crossoverLogFileName);
	}
	
	protected void logWithoutException(String s) {
		try {
			crossoverLog.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
