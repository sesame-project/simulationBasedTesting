package uk.ac.york.sesame.testing.architecture.data;

public interface ILogger {
	
	public String getType();
	public Boolean appendLine(String line);
	public String readLine(int lineNumber);

}
