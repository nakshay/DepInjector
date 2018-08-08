package io.github.nakshay.depinjector;

import java.io.File;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConfigurationReader {

    static void readConfig(final String filePath, Map<String, Object> objectStrage) {
        
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("instance");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Element eElement = (Element) nodeList.item(i);
                objectStrage.put(eElement.getAttribute("name"),eElement.getTextContent());
            }    
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}