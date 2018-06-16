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
import MainClasses.MainClass;
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
 *  Description: This file handles all of the opening and saving of data to the disks.
 */

public class FileManager {
    
    /* This method handles the opening of medical data files which is initiated when the user attempts to log in */
    public static void open () {
        
        /* Surround opening test types function with try-catch to catch all IO errors */
        try {
            /* Find and load the test type medical data file into the memory */
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("src/DataStorage/XMLFiles/" + MainClass.currentUsername + "/testtypes.xml"));
            doc.getDocumentElement().normalize();
            
            /* Create an array filled with all of the test types stored in the file */
            NodeList testTypeList = doc.getElementsByTagName("TestType");
            
            /* Loop through all of the test types in the array */
            for (int x = 0; x < testTypeList.getLength(); x++) {
                
                /* Use temporary variables to retrieve the attributes of the test type */
                Element testType = (Element) testTypeList.item(x);
                String name = testType.getElementsByTagName("Name").item(0).getTextContent();
                double greenMinimumScore = Double.parseDouble(testType.getElementsByTagName("GreenMinimumScore").item(0).getTextContent());
                double greenMaximumScore = Double.parseDouble(testType.getElementsByTagName("GreenMaximumScore").item(0).getTextContent());
                double yellowMinimumScore = Double.parseDouble(testType.getElementsByTagName("YellowMinimumScore").item(0).getTextContent());
                double yellowMaximumScore = Double.parseDouble(testType.getElementsByTagName("YellowMaximumScore").item(0).getTextContent());
                
                /* 
                   Use temporary variables to create a new test type object and add it to the
                   main array for easy access by other functions in the program.
                */
                
                MainController.testTypes.add(new MedicalTestType(name, greenMinimumScore, greenMaximumScore, yellowMinimumScore, yellowMaximumScore));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /* Surround opening medical data function with try-catch to catch all IO errors */
        try {
            
            /* Find and load the medical data file into the memory */
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("src/DataStorage/XMLFiles/" + MainClass.currentUsername + "/medicaldata.xml"));
            doc.getDocumentElement().normalize();
            
            /* Create an array filled with all of the medical data entries stored in the file */
            NodeList testTypeList = doc.getElementsByTagName("TestEntry");
            
            /* Loop through the test entries in the array */
            for (int x = 0; x < testTypeList.getLength(); x++) {
                /* Create variable to hold the index of the desired test type in the main array */
                int index = 0;
                
                /* 
                    Medical data is stored in a format organized where the test types are
                    parents of the tests of that type. This code will first find the test type 
                    of the medical data and find its index in the main array. It will then go
                    through all of the tests which are its children and add them to the test type's
                    array containing all of the tests.
                */
                
                /* 
                    Each entry has a test type associated with it. This will find the test type and
                   store it into the name variable.
                */
                
                Element testType = (Element) testTypeList.item(x);
                String name = testType.getElementsByTagName("Type").item(0).getTextContent();
                
                /* Find the index of the test type in the main array */
                for (int i = 0; i < MainController.testTypes.size(); i++) {
                    if (name.equals(MainController.testTypes.get(i).getName())) { 
                        index = i;
                    }
                }
                
                /*
                    In the organization of the medical data storage a container element
                    called "Tests" is used in the XML file to hold all of the tests. This
                    code will find the container and loop through it to retirieve the test
                    data.
                */
                
                Element testsContainer = (Element) testType.getElementsByTagName("Tests").item(0);
                
                /* Create temporary array of tests to hold all the tests after they have been retrieved */
                ArrayList<MedicalTestResult> testArray = new ArrayList<MedicalTestResult> ();
                
                /* Create array of all the test elements in the XML */
                NodeList tests = testsContainer.getElementsByTagName("Test");
                
                /* Loop through elements array to gather each tests information */
                for (int y = 0; y < tests.getLength(); y++) {
                    /* Create temporary variables to retrieve the data fields */
                    Element test = (Element) tests.item(y);
                    Date date = new Date (test.getElementsByTagName("Date").item(0).getTextContent());
                    String score = test.getElementsByTagName("Score").item(0).getTextContent();
                    
                    /* Create a test object out of the information above and add it to temporary array */
                    testArray.add(new MedicalTestResult(date, Integer.parseInt(score)));
                }
                
                /* Set the test type's array to the temporary one to set all tests into memory */
                MainController.testTypes.get(index).setTests(testArray);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /* This method handles all of the saving features of the program */
    public static void save () {
        /* Surround saving medical data function with try-catch to catch all IO errors */
        try {
            /* Create a new document where the medical data will be stored */
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            /* Create a root element for the XML document */
            Element root = doc.createElement("MedicalData");
            doc.appendChild(root);
            
            /* Loop through all test types in main array */
            for (int x = 0; x < MainController.testTypes.size(); x++) {
                /* Create a new test entry for the test type */
                Element testType = doc.createElement("TestEntry");
                
                /* Save the type information into the XML under a element */
                Element type = doc.createElement("Type");
                type.setTextContent(MainController.testTypes.get(x).getName());
                
                /* Create a container to hold all of the tests under that type */
                Element tests = doc.createElement("Tests");
                
                /* Add the type name and tests as children of the entry */
                testType.appendChild(type);
                testType.appendChild(tests);
                
                /* Loop through all of the tests under that type */
                for (int y = 0; y < MainController.testTypes.get(x).getTests().size(); y++) {
                    
                    /* Create a new test element */
                    Element test = doc.createElement("Test");
                    
                    /* Create an element to store the date */
                    Element date = doc.createElement("Date");
                    date.setTextContent(MainController.testTypes.get(x).getTests().get(y).getDate().toString());
                    
                    /* Create an element to store the score */
                    Element score = doc.createElement("Score");
                    score.setTextContent(String.valueOf(MainController.testTypes.get(x).getTests().get(y).getScore()));
                    
                    /* Add date and score as childs of the test */
                    test.appendChild(date);
                    test.appendChild(score);
                    
                    /* Add the test as a child of the container */
                    tests.appendChild(test);
                }
                
                /* Add all of the test types to the root element */
                root.appendChild(testType);
                
                /* Surround the storage to disk with try-catch to catch all IO errors */
                try {
                    /* Set the XML configuration */
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    
                    /* Output document to a file on the hard disk */
                    transformer.transform(new DOMSource (doc), new StreamResult(new FileOutputStream("src/DataStorage/XMLFiles/" + MainClass.currentUsername + "/medicaldata.xml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /* Surround saving test types function with try-catch to catch all IO errors */
        try {
            /* Create a new document to hold all the test types */
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            /* Create a root element for the XML */
            Element root = doc.createElement("MedicalTypes");
            doc.appendChild(root);
            
            /* Loop through all of the test types in the main array */
            for (int x = 0; x < MainController.testTypes.size(); x++) {
                /* Create a new element for the test type */
                Element testType = doc.createElement("TestType");
                
                /* Create an element to hold the name */
                Element name = doc.createElement("Name");
                name.setTextContent(MainController.testTypes.get(x).getName());
                
                /* Create a new element to hold the green zone minimum score */
                Element greenMinimumScore = doc.createElement("GreenMinimumScore");
                greenMinimumScore.setTextContent(Double.toString(MainController.testTypes.get(x).getGreenMinimumScore()));
                
                /* Create a new element to hold the green zone maxiumum score */
                Element greenMaximumScore = doc.createElement("GreenMaximumScore");
                greenMaximumScore.setTextContent(Double.toString(MainController.testTypes.get(x).getGreenMaximumScore()));
                
                /* Create a new element to hold the yellow zone minimum score */
                Element yellowMinimumScore = doc.createElement("YellowMinimumScore");
                yellowMinimumScore.setTextContent(Double.toString(MainController.testTypes.get(x).getYellowMinimumScore()));
                
                /* Create a new element to hold the yelllow zone maximum score */
                Element yellowMaximumScore = doc.createElement("YellowMaximumScore");
                yellowMaximumScore.setTextContent(Double.toString(MainController.testTypes.get(x).getYellowMaximumScore()));
                
                /* Add all of the attributes as a child of the test type */
                testType.appendChild(name);
                testType.appendChild(greenMinimumScore);
                testType.appendChild(greenMaximumScore);
                testType.appendChild(yellowMinimumScore);
                testType.appendChild(yellowMaximumScore);
                
                /* Add the test type as a child of the root element */       
                root.appendChild(testType);
                
                /* Surround the saving to disk with try-catch to catch all IO errors */
                try {
                    /* Set the XML format */
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    
                    /* Save the test type document to the hard disk */
                    transformer.transform(new DOMSource (doc), new StreamResult(new FileOutputStream("src/DataStorage/XMLFiles/" + MainClass.currentUsername + "/testtypes.xml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
