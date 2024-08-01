package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

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
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.OperationExecutor;

public class XMLConfigTransformer extends ConfigTransformer {
	private XMLConfigLocation xmlVar;

	public XMLConfigTransformer(FileAccessorFromDependency accessor, XMLConfigLocation xmlVar) {
		super(accessor);
		this.xmlVar = xmlVar;
	}

	@Override
	public void transform(Random rng, OperationExecutor executor) throws TransformFailed {
		Transformer xformer;
		InputSource inputSource = accessor.getConfigFileInput(xmlVar);
		Optional<StreamResult> streamResult_o = accessor.getStreamForOutputResult(xmlVar);

		if (!streamResult_o.isPresent()) {
			System.err.println("Transform of static variable failed - could not create output stream for " + xmlVar.toString());
			throw new TransformFailed();
		} else {
			// Get the file from the source
			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
				XPath xpath = XPathFactory.newInstance().newXPath();
				// Select the current value in the document
				String xpathExprStr = xmlVar.getXpathExpression();
				NodeList nodes = (NodeList) xpath.evaluate(xpathExprStr, doc, XPathConstants.NODESET);

				for (int idx = 0; idx < nodes.getLength(); idx++) {
					Object original = nodes.item(idx).getTextContent();
					Object changedValue = executor.exec(rng, original);
					nodes.item(idx).setTextContent(changedValue.toString());
				}

				xformer = TransformerFactory.newInstance().newTransformer();
				xformer.transform(new DOMSource(doc), streamResult_o.get());
				System.out.println("Done transform for " + xmlVar.toString());

			} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
				e.printStackTrace();
				throw new TransformFailed();
			} catch (TransformerException e) {
				e.printStackTrace();
				throw new TransformFailed();
			} catch (SAXException e) {
				e.printStackTrace();
				throw new TransformFailed();
			} catch (IOException e) {
				e.printStackTrace();
				throw new TransformFailed();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw new TransformFailed();
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw new TransformFailed();
			}
		}

	}
}