package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.XMLConfigLocation;

public class XMLConfigTransformer extends ConfigTransformer {
	private XMLConfigLocation xmlVar;
	
	public XMLConfigTransformer(FileAccessorFromDependency accessor, XMLConfigLocation xmlVar) {
		super(accessor);
		this.xmlVar = xmlVar;
	}

	@Override
	public void transform(Object changedVarValue) {
		Transformer xformer;
		InputSource inputSource = accessor.getConfigFileInput();
		StreamResult streamResult = accessor.getStreamForOutputResult();
		// Get the file from the source
		try {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
		XPath xpath = XPathFactory.newInstance().newXPath();
		// Select the current value in the document
		String xpathExprStr = xmlVar.getXpathExpression();
		NodeList nodes = (NodeList)xpath.evaluate(xpathExprStr, doc,XPathConstants.NODESET);

		// TODO: how to get the changed value? - needs to be passed into here from the fuzzing operation?
		String changedValue = (String)changedVarValue.toString();
		
		for (int idx = 0; idx < nodes.getLength(); idx++) {
			nodes.item(idx).setTextContent(changedValue.toString());
		}

		xformer = TransformerFactory.newInstance().newTransformer();
		xformer.transform(new DOMSource(doc), streamResult);
		
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done transform for " + this.toString());
	}
}