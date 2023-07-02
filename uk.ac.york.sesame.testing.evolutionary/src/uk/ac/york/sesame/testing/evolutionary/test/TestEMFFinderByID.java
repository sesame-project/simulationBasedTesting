package uk.ac.york.sesame.testing.evolutionary.test;

import java.util.Optional;

import org.buildobjects.process.ProcResult;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;
import uk.ac.york.sesame.testing.evolutionary.utilities.PathDefinitions;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class TestEMFFinderByID {
	
	public static void main(String [] args) {
		String spaceModelFilename = "/home/jharbin/eclipse-workspace-sesame/TTSTestProject/models/results/repeated-res-tts-determinismTests.model";
		SESAMEModelLoader loader = new SESAMEModelLoader(spaceModelFilename);
		try {
			Resource r = loader.loadTestingSpace();
			TreeIterator<EObject> obs = r.getAllContents();
			while (obs.hasNext()) {
				EObject eo = obs.next();
				System.out.println("ID = " + EcoreUtil.getID(eo));
				EClass cls = eo.eClass();
				for (EAttribute a : cls.getEAttributes()) {
					System.out.println(a.toString());
				}
				
			}
			
				
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
