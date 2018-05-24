/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStorage;

import DataTypes.Date;
import DataTypes.MedicalTestResult;
import DataTypes.MedicalTestType;
import FXMLControllers.MainController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *  File Name: SaveFile
 *  Date: May 15, 2018
 *  Description:
 */
public class FileManager {
    
    private static Element name;
    private static Element comment;
    private static Element greenMinimumScore;
    private static Element greenMaximumScore;
    private static Element yellowMinimumScore;
    private static Element yellowMaximumScore;
    private static Element date;
    private static Element score;
    
    public static void open () {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("src/DataStorage/XMLFiles/medicaldata.xml"));
            doc.getDocumentElement().normalize();
            
            NodeList testTypeList = doc.getElementsByTagName("TestType");
            
            for (int x = 0; x < testTypeList.getLength(); x++) {
                Element testType = (Element) testTypeList.item(x);
                String name = testType.getElementsByTagName("Name").item(0).getTextContent();
                String description = testType.getElementsByTagName("Description").item(0).getTextContent();
                int greenMinimumScore = Integer.parseInt(testType.getElementsByTagName("GreenMinimumScore").item(0).getTextContent());
                int greenMaximumScore = Integer.parseInt(testType.getElementsByTagName("GreenMaximumScore").item(0).getTextContent());
                int yellowMinimumScore = Integer.parseInt(testType.getElementsByTagName("YellowMinimumScore").item(0).getTextContent());
                int yellowMaximumScore = Integer.parseInt(testType.getElementsByTagName("YellowMaximumScore").item(0).getTextContent());
                Element testsContainer = (Element) testType.getElementsByTagName("Tests").item(0);
                
                ArrayList<MedicalTestResult> testArray = new ArrayList<MedicalTestResult> ();
                NodeList tests = testsContainer.getElementsByTagName("Test");
                for (int y = 0; y < tests.getLength(); y++) {
                    Element test = (Element) tests.item(y);
                    Date date = new Date (test.getElementsByTagName("Date").item(0).getTextContent());
                    String score = test.getElementsByTagName("Score").item(0).getTextContent();
                    testArray.add(new MedicalTestResult(date, Integer.parseInt(score)));
                }
                MainController.testTypes.add(new MedicalTestType(name, description, greenMinimumScore, greenMaximumScore, yellowMinimumScore, yellowMaximumScore, testArray));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
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
                
                Element greenMinimumScore = doc.createElement("GreenMinimumScore");
                greenMinimumScore.setTextContent(Integer.toString(MainController.testTypes.get(x).getGreenMinimumScore()));
                
                Element greenMaximumScore = doc.createElement("GreenMaximumScore");
                greenMaximumScore.setTextContent(Integer.toString(MainController.testTypes.get(x).getGreenMaximumScore()));
                
                Element yellowMinimumScore = doc.createElement("YellowMinimumScore");
                yellowMinimumScore.setTextContent(Integer.toString(MainController.testTypes.get(x).getYellowMinimumScore()));
                
                Element yellowMaximumScore = doc.createElement("YellowMaximumScore");
                yellowMaximumScore.setTextContent(Integer.toString(MainController.testTypes.get(x).getYellowMaximumScore()));
                
                Element tests = doc.createElement("Tests");
                
                testType.appendChild(name);
                testType.appendChild(description);
                testType.appendChild(greenMinimumScore);
                testType.appendChild(greenMaximumScore);
                testType.appendChild(yellowMinimumScore);
                testType.appendChild(yellowMaximumScore);
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
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    
                    transformer.transform(new DOMSource (doc), new StreamResult(new FileOutputStream("src/DataStorage/XMLFiles/medicaldata.xml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
