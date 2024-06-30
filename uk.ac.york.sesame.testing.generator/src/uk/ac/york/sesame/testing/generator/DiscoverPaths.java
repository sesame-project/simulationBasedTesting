package uk.ac.york.sesame.testing.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class DiscoverPaths {
	private static boolean isRepoBase(File dir) {
		boolean check = new File(dir, "uk.ac.york.sesame.testing.generator").exists();
		return check;
	}

	public static Optional<File> scanParentsForRepoBase(File dir) {
		System.out.println("scanParentsForRepoBase: scanning " + dir.getAbsolutePath());
		if (isRepoBase(dir)) {
			return Optional.of(dir);
		} else {
			String parent = dir.getParent();
			if (parent == null) {
				return Optional.empty();
			} else {
				return scanParentsForRepoBase(new File(parent));
			}
		}
	}

	public static Optional<File> findRepoBase() {
		String currentProjectDir = System.getProperty("user.dir");
		Optional<File> repoBaseDir = scanParentsForRepoBase(new File(currentProjectDir));
		return repoBaseDir;
	}

	public static File findGeneratorProject(File repoBaseDir) {
		return new File(repoBaseDir, "uk.ac.york.sesame.testing.generator");
	}

	public static File getModelDirectory(File repoBaseDir) {
		return new File(repoBaseDir, "/uk.ac.york.sesame.testing.dsl/models/");
	}

	public static String getModelDirectoryAsString() throws ErrorGettingPath {
		Optional<File> repoBaseDir_o = findRepoBase(); 
		if (repoBaseDir_o.isPresent()) {
			return getModelDirectory(repoBaseDir_o.get()).getAbsolutePath();
		} else {
			throw new ErrorGettingPath();
		}
	}
	
	public static File propertiesFile() {
		String homeDir = System.getProperty("user.home");
		return new File(homeDir + "/simtesting.properties");
	}
	
	public static Properties loadPropertiesFile() throws MissingPropertiesFile {
		Properties props = new Properties();
		File propsLocation = propertiesFile();
		try {
			props.load(new FileInputStream(propsLocation));
			return props;
		} catch (IOException e) {
			e.printStackTrace();
			throw new MissingPropertiesFile(propsLocation);
		}
	}
	
	public static void updatePropertiesFile(Properties props) throws MissingPropertiesFile {
		File propsLocation = propertiesFile();
		try {
			props.store(new FileOutputStream(propsLocation), "Auto-generated properties");
		} catch (IOException e) {
			e.printStackTrace();
			throw new MissingPropertiesFile(propsLocation);
		}
	}

	public static void main(String[] args) {
		//String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//System.out.println("Root path " + rootPath);
//		System.out.println("Home Directory: " + System.getProperty("user.home"));
//		System.out.println("Present Project Directory: " + System.getProperty("user.dir"));
		
		Properties props = new Properties();
		Optional<File> repoBaseDir_o = findRepoBase();
		if (repoBaseDir_o.isPresent()) {
			File repoBaseDir = repoBaseDir_o.get();
			File metamodelFile = new File(repoBaseDir, "/uk.ac.york.sesame.testing.dsl/models/TestingMM.ecore");
			File genProjectDir = findGeneratorProject(repoBaseDir);
			System.out.println("Generator project dir:" + genProjectDir.getAbsolutePath());	
			props.setProperty("TESTING_METAMODEL_FILE", metamodelFile.getAbsolutePath());
			props.setProperty("GENERATOR_PROJECT_DIR", genProjectDir.getAbsolutePath());
			try {
				updatePropertiesFile(props);
				System.out.println("Properties updated and stored at " + propertiesFile().getAbsolutePath());
			} catch (MissingPropertiesFile e) {
				e.printStackTrace();
			}
			
		}
	}
}
