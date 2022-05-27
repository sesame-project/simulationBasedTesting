package uk.ac.york.sesame.testing.evolutionary.utilities.temp;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.*;

public class UsingEMFModel {
    public static void main(String[] args) {
    	AttacksPackage s = AttacksPackage.eINSTANCE;
    	AttacksFactory factory = AttacksFactory.eINSTANCE;
    	
    	Attack myAttack = factory.createAttack();
    	
    	       
        Adapter adapter = new AdapterImpl() {
            public void notifyChanged(Notification notification) {
                System.out.println("Notfication received from the data model. Data model has changed!!!");
            }
        };
        // why are there no adapters
        //myAttack.eAdapters().add(adapter);
        myAttack.setName("ATTACK1");
        
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("website", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // create a resource
        Resource resource = resSet.createResource(URI.createURI("/tmp/attack.model"));
        // Get the first model element and cast it to the right type, in my
        // example everything is hierarchical included in this first node
        
        resource.getContents().add(myAttack);

        // now save the content.
        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}