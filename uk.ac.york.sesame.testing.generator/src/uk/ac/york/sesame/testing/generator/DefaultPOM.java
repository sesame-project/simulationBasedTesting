package uk.ac.york.sesame.testing.generator;

public class DefaultPOM {

	public static String contents() {
		return "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n"
				+ "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
				+ "	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd\">\n"
				+ "	<modelVersion>4.0.0</modelVersion>\n"
				+ "	<groupId>uk.ac.york.sesame.testing.architecture.testing</groupId>\n"
				+ "	<artifactId>uk.ac.york.sesame.testing.architecture.testing</artifactId>\n"
				+ "	<version>0.0.1-SNAPSHOT</version>\n"
				+ "	<dependencies>\n"
				+ "		<dependency>\n"
				+ "			<groupId>uk.ac.york.sesame.testing.architecture.ros</groupId>\n"
				+ "			<artifactId>uk.ac.york.sesame.testing.architecture.ros</artifactId>\n"
				+ "			<version>0.0.1-SNAPSHOT</version>\n"
				+ "		</dependency>\n"
				+ "		<dependency>\n"
				+ "			<groupId>uk.ac.york.sesame.testing.architecture</groupId>\n"
				+ "			<artifactId>uk.ac.york.sesame.testing.architecture</artifactId>\n"
				+ "			<version>0.0.1-SNAPSHOT</version>\n"
				+ "		</dependency>\n"
				+ "	</dependencies>\n"
				+ "	<build>\n"
				+ "		<sourceDirectory>src</sourceDirectory>\n"
				+ "		<plugins>\n"
				+ "			<plugin>\n"
				+ "				<artifactId>maven-compiler-plugin</artifactId>\n"
				+ "				<version>3.8.0</version>\n"
				+ "				<configuration>\n"
				+ "					<release>11</release>\n"
				+ "				</configuration>\n"
				+ "			</plugin>\n"
				+ "		</plugins>\n"
				+ "	</build>\n"
				+ "</project>";
	}
	
}
