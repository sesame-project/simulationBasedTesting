package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import java.util.Optional;
import java.io.File;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;

import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.xml.sax.InputSource;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ContainerDependency;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.FileLocation;
import uk.ac.york.sesame.testing.evolutionary.distributed.RemoteTest;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingPropertiesFile;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingProperty;
import uk.ac.york.sesame.testing.evolutionary.utilities.PathLookupFromProperties;

public class FileAccessorFromDocker extends FileAccessorFromDependency {

	private ContainerDependency depRoot;
	DockerClient dockerClient;
	String sourceContainerID;
	RemoteTest remoteTest;
	
	String tempSourceCopy = "/tmp/testSource.xml";
	
	public FileAccessorFromDocker(RemoteTest remoteTest, ContainerDependency depRoot) {
		this.depRoot = depRoot;
		this.remoteTest = remoteTest;
		DockerClientConfig standard = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
		dockerClient = DockerClientBuilder.getInstance(standard).build();
	}

	@Override
	public InputSource getConfigFileInput(FileLocation loc) {
		
		// // Example from: https://github.com/docker-java/docker-java/issues/991
		// Since copyArchiveFromContainerCmd is required (copyFileFromContainer not working)
		// we have to create a container, copy an archive from it and un-tar it
        // Create container
		String imageID = depRoot.getImageName();
		// TODO: verify here that the image exists!
		String containerName = imageID + "_sourceContainer";
		String containerFile = loc.getFileName();
		
        try (CreateContainerCmd createContainer = dockerClient
                .createContainerCmd(imageID).withName(containerName)) {
            createContainer.withTty(true);
            createContainer.exec();
        }

        // Ensure the temp source is fresh
        File tempSourceFile = new File(tempSourceCopy);
        if (tempSourceFile.exists()) {
        	tempSourceFile.delete();
        }
        
        // Start container
        dockerClient.startContainerCmd(containerName).exec();

        // Copy file from container
        try (TarArchiveInputStream tarStream = new TarArchiveInputStream(
                dockerClient.copyArchiveFromContainerCmd(containerName,
                        containerFile).exec())) {
            DockerFileAccessUtils.unTar(tarStream, tempSourceFile);
        } catch (IOException e) {
			e.printStackTrace();
		}

        // Stop container
        dockerClient.killContainerCmd(containerName).exec();

        // Remove container
        dockerClient.removeContainerCmd(containerName).exec();
		
        InputSource source = new InputSource(tempSourceCopy);
		return source;
	}

	@Override
	public void finalise() {
		
	}

	@Override
	public Optional<StreamResult> getStreamForOutputResult(FileLocation loc) {
		String codeGenerationDir;
		try {
			codeGenerationDir = PathLookupFromProperties.getProperty(PathLookupFromProperties.PathSpec.SHARED_CODE_DIRECTORY);
			String modifiedFilesSuffix = "static-var-modified";
			String testID = remoteTest.getTestID();
			String outputFileName = codeGenerationDir + File.separator + modifiedFilesSuffix + File.separator + testID + File.separator + depRoot.getImageName() + File.separator + loc.getFileName();			
			
			File outFile = new File(outputFileName);
			File parentDir = outFile.getParentFile();
			// Ensure the nested directory exists
			if (!parentDir.exists()) {
				parentDir.mkdirs();
			}
			System.out.println("Writing static variable to " + outputFileName);
			return Optional.of(new StreamResult(new File(outputFileName)));
		} catch (MissingProperty | MissingPropertiesFile e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
