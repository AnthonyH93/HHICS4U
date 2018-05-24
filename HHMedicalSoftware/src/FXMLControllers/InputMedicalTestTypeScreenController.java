package FXMLControllers;


import MainClasses.InputMedicalTestTypeScreen;
import DataTypes.MedicalTestType;
import MainClasses.MainClass;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: InputMedicalTestDataScreenController
 *  Date: May 11, 2018
 *  Description: This class acts as the controller for the test type screen.
 */
public class InputMedicalTestTypeScreenController implements Initializable {
    
    /* Inject all FXML Components */
    
    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Pane topBarPane;

    @FXML
    private Label titleLabel;

    @FXML
    private Pane bottomPane;

    @FXML
    private GridPane mainGridPane;

    @FXML
    private TextField nameTextField;

    @FXML
    private ImageView logoView;

    @FXML
    private Label nameLabel;
    
    @FXML
    private TextArea commentTextArea;
    
    @FXML
    private Label commentLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* When button is pressed add data to array and close the window */
        submitButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    if (!nameTextField.getText().equals("")) {
                        InputMedicalTestTypeScreen.close();
                        MainClass.controller.updateMedicalTestTypeList();
                    }
                }
                
            });
        
        /* When button is pressed close the window */
        cancelButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                InputMedicalTestTypeScreen.close();
            }  
        });
    }
    
    
}
