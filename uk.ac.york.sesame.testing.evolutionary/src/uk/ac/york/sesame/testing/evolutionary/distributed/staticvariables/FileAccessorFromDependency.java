package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import java.util.Optional;

import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.FileLocation;

public abstract class FileAccessorFromDependency {
	public abstract InputSource getConfigFileInput(FileLocation loc);
	public abstract Optional<StreamResult> getStreamForOutputResult(FileLocation loc);
	
	/** This will e.g. write back the files to the container */
	public abstract void finalise();
}
