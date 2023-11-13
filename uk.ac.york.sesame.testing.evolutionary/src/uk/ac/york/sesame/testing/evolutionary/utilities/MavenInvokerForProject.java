package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.io.File;
import java.util.Collections;

import org.apache.maven.shared.invoker.*;

public class MavenInvokerForProject {
	
	private final File MAVEN_EXECUTABLE = new File("C:\\cygwin64\\home\\James\\source\\maven-3.9.0\\apache-maven-3.9.0\\bin\\mvn.cmd");
	private final File JAVA_HOME = new File("C:\\Program Files\\Java\\jdk-11.0.17");
	
	Invoker invoker;
	private final File pomFile;
	
	public MavenInvokerForProject(String projectDirectory) {
		invoker = new DefaultInvoker();
		invoker.setMavenExecutable(MAVEN_EXECUTABLE);
		String pomPath = projectDirectory + "\\pom.xml";
		pomFile = new File(pomPath);
	}
	
	public void compileProject() throws MavenInvocationException {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(pomFile);
		request.setJavaHome(JAVA_HOME);
		request.setGoals(Collections.singletonList("compile"));
		invoker.execute(request);
	}
	
	public void exec(String targetClass) {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(pomFile);
		request.setJavaHome(JAVA_HOME);
		request.setGoals(Collections.singletonList("exec:java"));
		request.setMavenOpts("-DmainClass=" + targetClass);
		
		Thread thread = new Thread() {
			public void run() {
				System.out.println("Invoking Maven with " + targetClass);
				try {
					invoker.execute(request);
				} catch (MavenInvocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		thread.run();
	}
}