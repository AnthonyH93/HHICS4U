/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStorage;

import FXMLControllers.MainController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *  File Name: SaveFile
 *  Date: May 15, 2018
 *  Description:
 */
public class FileManager {
    
    private static Element name;
    private static Element comment;
    private static Element date;
    private static Element score;
    
    public static void open () {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("src/DataStorage/XMLFiles/medicaldata.xml"));
            doc.getDocumentElement().normalize();
            
            
        } catch (Exception e) {
            
        }
    }
    
    public static void save () {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            Element root = doc.createElement("MedicalData");
            doc.appendChild(root);
            
            for (int x = 0; x < MainController.testTypes.size(); x++) {
                Element testType = doc.createElement("TestType");
                
                Element name = doc.createElement("Name");
                name.setTextContent(MainController.testTypes.get(x).getName());
                
                Element description = doc.createElement("Description");
                description.setTextContent(MainController.testTypes.get(x).getDescription());
                
                Element tests = doc.createElement("Tests");
                
                testType.appendChild(name);
                testType.appendChild(description);
                testType.appendChild(tests);
                
                for (int y = 0; y < MainController.testTypes.get(x).getTests().size(); y++) {
                    Element test = doc.createElement("Test");
                    
                    Element date = doc.createElement("Date");
                    date.setTextContent(MainController.testTypes.get(x).getTests().get(y).getDate().toString());
                    
                    Element score = doc.createElement("Score");
                    score.setTextContent(String.valueOf(MainController.testTypes.get(x).getTests().get(y).getScore()));
                    
                    test.appendChild(date);
                    test.appendChild(score);
                    
                    tests.appendChild(test);
                }
                
                root.appendChild(testType);
                
                try {
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "medicaldata.xml");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    
                    transformer.transform(new DOMSource (doc), new StreamResult(new FileOutputStream("src/DataStorage/XMLFiles/medicaldata.xml")));
                    transformer.transform(new DOMSource (doc), new StreamResult(System.out));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
