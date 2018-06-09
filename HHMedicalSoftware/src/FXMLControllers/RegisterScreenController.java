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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *  File Name: LoginScreenController
 *  Date: Jun 6, 2018
 *  Description:
 */
public class RegisterScreenController implements Initializable {
    
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
    
    String password;
    String username;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                try {
            
                    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                    Document doc = docBuilder.parse(new File("src/DataStorage/XMLFiles/" + username + "/userdata.xml"));
                    doc.getDocumentElement().normalize();
                    
                    outputLabel.setText("This User Already Exists");
            
                } catch (IOException e) {
                    try {
                        
                        username = userNameField.getText();
                        password = passwordField.getText();
                        
                        File dir = new File("src/DataStorage/XMLFiles/" + username);
                        try {
                            dir.mkdir();
                        } catch (SecurityException s) {
                            s.printStackTrace();
                        }
                        
                        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                        Document doc = docBuilder.newDocument();
                        
                        Element pass = doc.createElement("Password");
                        pass.setTextContent(password);
                        doc.appendChild(pass);
                        
                        try {
                            Transformer transformer = TransformerFactory.newInstance().newTransformer();
                            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                    
                            transformer.transform(new DOMSource (doc), new StreamResult(new FileOutputStream("src/DataStorage/XMLFiles/" + username + "/userdata.xml")));
                        } catch (IOException i) {
                            i.printStackTrace();
                        } catch (TransformerException ex) {
                            Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SAXException ex) {
                    Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                RegisterScreen.close();
            }
        });
        
    }
}
