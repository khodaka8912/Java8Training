package ch04.ex08;

import javafx.scene.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author hodaka
 */
public class FxmlParser {

    static Node parse(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        Node node = paarseNode(doc.getFirstChild());
        return node;
    }

    private static Node paarseNode(org.w3c.dom.Node docNode) throws IOException {
        String typeName = docNode.getNodeName();
        Node node;
        try {
            node = (Node) Class.forName(typeName).getConstructor(null).newInstance(null);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        NamedNodeMap attrs = docNode.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Node attr = attrs.item(i);
            String name = attr.getNodeName();
            if (name.contains(".")) {
                // TODO
            }
        }
        NodeList children = docNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            org.w3c.dom.Node child = children.item(i);
            // TODO
        }
        return node;
    }

    private static String toSetterName(String attributeName) {
        return "set" + Character.toTitleCase(attributeName.charAt(0)) + attributeName.substring(1);
    }
}
