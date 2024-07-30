package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

public abstract class FileAccessorFromDependency {
	public abstract InputSource getConfigFileInput();
	public abstract StreamResult getStreamForOutputResult();
	
	/** This will e.g. write back the files to the container */
	public abstract void finalise();
}
