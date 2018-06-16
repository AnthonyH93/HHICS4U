/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FXMLControllers;

import MainClasses.MainClass;
import MainClasses.MainScreen;
import MainClasses.RegisterScreen;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *  File Name: RegisterScreenController
 *  Date: Jun 6, 2018
 *  Description: This screen handles registering the user.
 */
public class RegisterScreenController implements Initializable {
    
    /* Inject all FXML elements */
    
    @FXML
    private ImageView backgroundImage;

    @FXML
    private VBox centerBox;

    @FXML
    private HBox buttonBox;

    @FXML
    private Label signInLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private HBox userNameBox;

    @FXML
    private Pane topPane;

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField userNameField;

    @FXML
    private Button registerButton;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private HBox passwordBox;

    @FXML
    private Pane centerPane;
    
    @FXML
    private Label outputLabel;
    
    /* Create two variables to hold the username and password */
    String password;
    String username;
    
    
    /* Initilize the components */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* This code is run when the register button is clicked */
        registerButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                
                /* Retrieve the username and passoword and store them into memory */
                username = userNameField.getText();
                password = passwordField.getText();
                
                /* Create the paths that are to be used to store the user's information */
                File dir = new File("src/DataStorage/XMLFiles/" + username);
                File testTemplate = new File("src/DataStorage/XMLFiles/testtypesTemplate.xml");
                File medicaldataTemplate = new File("src/DataStorage/XMLFiles/medicaldataTemplate.xml");
                
                /* If the username or password is blank or directory is already in use alert user, else proceed */
                if (username.equals("") || password.equals("")) {
                    outputLabel.setText("You Cannot Leave This Field Blank");
                } else if (dir.exists()) {
                    
                    outputLabel.setText("This User Already Exists");
            
                } else {
                    try {
                        /* Try to create the folder for the user data, catch security exception */
                        try {
                            dir.mkdir();
                        } catch (SecurityException s) {
                            s.printStackTrace();
                        }
                        
                        /* Create a new document to hold the password */
                        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                        Document doc = docBuilder.newDocument();
                        
                        /* Create the password element */
                        Element pass = doc.createElement("Password");
                        pass.setTextContent(password);
                        doc.appendChild(pass);
                        
                        /* Surround with try-catch to catch IO errors */
                        try {
                            /* Set XML format */
                            Transformer transformer = TransformerFactory.newInstance().newTransformer();
                            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    
                            /* Output the XML file to the new folder */
                            transformer.transform(new DOMSource (doc), new StreamResult(new FileOutputStream("src/DataStorage/XMLFiles/" + username + "/userdata.xml")));
                            
                            /* Copy the test type and medical data empty xml templates for the user folder */
                            Files.copy(testTemplate.toPath(), dir.toPath().resolve("testtypes.xml"), StandardCopyOption.REPLACE_EXISTING);
                            Files.copy(medicaldataTemplate.toPath(), dir.toPath().resolve("medicaldata.xml"), StandardCopyOption.REPLACE_EXISTING);
                            
                        } catch (IOException i) {
                            i.printStackTrace();
                        } catch (TransformerException ex) {
                            Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    /* Close the screen when done */
                    RegisterScreen.close();
                }
                
            }
        });
        
    }
}
