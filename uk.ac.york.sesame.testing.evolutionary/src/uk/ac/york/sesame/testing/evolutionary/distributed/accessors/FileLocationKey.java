package uk.ac.york.sesame.testing.evolutionary.distributed.accessors;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ContainerDependency;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.FileLocation;

public class FileLocationKey {
	public static String forDepFile(ContainerDependency dep, FileLocation fl) {
		String imageName = ((ContainerDependency)dep).getImageName();
		String fileName = fl.getFileName();
		String key = imageName + "-" + fileName;
		return key;
	}
}
