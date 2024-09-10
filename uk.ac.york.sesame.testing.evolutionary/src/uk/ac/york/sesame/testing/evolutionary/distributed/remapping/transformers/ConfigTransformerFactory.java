package uk.ac.york.sesame.testing.evolutionary.distributed.remapping.transformers;

import java.util.ArrayList;
import java.util.List;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ContainerDependency;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.Dependency;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ConfigLocation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.DynamicVariable;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.StaticVariable;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.XMLConfigLocation;
import uk.ac.york.sesame.testing.evolutionary.distributed.RemoteTest;
import uk.ac.york.sesame.testing.evolutionary.distributed.accessors.FileAccessorFromDependency;
import uk.ac.york.sesame.testing.evolutionary.distributed.accessors.FileAccessorFromDocker;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.InvalidTransformerForVariable;

public class ConfigTransformerFactory {
	public List<ConfigTransformer> createTransformers(RemoteTest rt, StaticVariable sv) throws InvalidTransformerForVariable {
		List<ConfigLocation> locs = sv.getLocations();
		
		List<ConfigTransformer> txs = new ArrayList<ConfigTransformer>();
		
		for (ConfigLocation l : locs) {
			Dependency depRoot = l.getRoot();
			
			FileAccessorFromDependency accessor = null;
			// TODO: support other containers here
			if (depRoot instanceof ContainerDependency) {
				accessor = new FileAccessorFromDocker(rt, (ContainerDependency)depRoot);	
			}
			
			if (accessor == null) {
				throw new InvalidTransformerForVariable(sv);
			}
			
			if (l instanceof XMLConfigLocation) {
				XMLConfigLocation xl = (XMLConfigLocation)l;
				txs.add(new XMLConfigTransformer(accessor, xl));
			}
		}
		
		return txs;
	}
}
