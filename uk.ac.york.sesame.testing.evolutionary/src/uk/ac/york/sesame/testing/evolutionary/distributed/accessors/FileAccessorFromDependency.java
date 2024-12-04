package uk.ac.york.sesame.testing.evolutionary.distributed.accessors;

import java.io.File;
import java.util.Optional;

import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.FileLocation;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingPropertiesFile;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingProperty;

public abstract class FileAccessorFromDependency {
	public abstract InputSource getConfigFileInput(FileLocation loc);
	public abstract String getOutputFileName(FileLocation loc) throws MissingProperty, MissingPropertiesFile;
	
	/** This will e.g. write back the files to the container 
	 * @throws FinaliseFailed */
	public abstract void finalise() throws FinaliseFailed;
	
	public Optional<StreamResult> getStreamForOutputResult(FileLocation loc) {
		try {
			String fileName = this.getOutputFileName(loc); 
			return Optional.of(new StreamResult(new File(fileName)));
		} catch (MissingProperty | MissingPropertiesFile e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
