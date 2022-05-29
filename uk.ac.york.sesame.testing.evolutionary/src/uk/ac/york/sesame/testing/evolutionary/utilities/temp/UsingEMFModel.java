package uk.ac.york.sesame.testing.evolutionary.utilities.temp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackageFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl;

public class UsingEMFModel {
	public Resource loadTestingSpace(String filename) {
		// Initialize the model
		AttacksPackage.eINSTANCE.eClass();
		TestingPackagePackage.eINSTANCE.eClass();

		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("model", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(URI.createURI(filename), true);
		return resource;
	}
	
	public void saveTestingSpace() {
		AttacksPackage s = AttacksPackage.eINSTANCE;
		AttacksFactory factory = AttacksFactory.eINSTANCE;

		Attack myAttack = factory.createAttack();

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification notification) {
				System.out.println("Notfication received from the data model. Data model has changed!!!");
			}
		};
		// why are there no adapters
		// myAttack.eAdapters().add(adapter);
		myAttack.setName("ATTACK2");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("model", new XMIResourceFactoryImpl());

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

	public static void main(String[] args) {
		UsingEMFModel emf = new UsingEMFModel();
		Resource testingSpaceModel = emf.loadTestingSpace("/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.dsl/models/testingHealthcareSpace.model");
		
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		TestingSpace space = (TestingSpace)testingSpaceModel.getContents().get(0);
		
		System.out.println("EMF loaded");
	
		TestingPackageFactory tFactory = TestingPackageFactory.eINSTANCE;
	
		EList<TestCampaign> tsList = space.getCampaigns();
		for (TestCampaign tc : tsList) {
			System.out.println("Found test campaign named " + tc.getName());
			EList<Test> tests = tc.getPerformedTests();
			Test t = tFactory.createTest();
			String date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
			t.setName("test-" + date);
			tests.add(t);
			System.out.println("Added a test to the model named " + t.getName());
		}
		
		try {
			testingSpaceModel.save(Collections.EMPTY_MAP);
			System.out.println("EMF saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}