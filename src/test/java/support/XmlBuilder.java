package support;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class XmlBuilder {
    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
    final Transformer transformer = transformerFactory.newTransformer();
    final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
    final Document document = documentBuilder.newDocument();
    final DOMSource source = new DOMSource(document);
    final StringWriter outWrite = new StringWriter();
    final StreamResult result = new StreamResult(outWrite);
    Element root;
    Element appendNode;

    public XmlBuilder() throws ParserConfigurationException, TransformerConfigurationException {
    }


    public void createRootNode(String NodeName) {
        root = document.createElement(NodeName);
        document.appendChild(root);
    }

    public void appendChildToRoot(String nodeName, String nodeValue) {
        appendNode = document.createElement(nodeName);
        appendNode.appendChild(document.createTextNode(nodeValue));
        root.appendChild(appendNode);
    }

    public String getXml() throws TransformerException {
        transformer.transform(source, result);
        StringBuffer sb = outWrite.getBuffer();
        return sb.toString();
    }
}
