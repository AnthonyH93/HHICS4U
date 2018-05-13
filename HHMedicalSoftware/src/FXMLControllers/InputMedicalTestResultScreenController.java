package FXMLControllers;


import MainClasses.InputMedicalTestResultScreen;
import DataTypes.Date;
import DataTypes.MedicalTestResult;
import MainClasses.MainClass;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 *  Programmer: 
 *  Date: May 11, 2018
 *  Description:
 */
public class InputMedicalTestResultScreenController implements Initializable {
    
    /* Inject all FXML Components */
    
    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Button submitButton;

    @FXML
    private TextField scoreTextField;

    @FXML
    private Pane topBarPane;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField dayTextField;

    @FXML
    private Pane bottomPane;

    @FXML
    private Label yearLabel;

    @FXML
    private ImageView logoView;

    @FXML
    private Label monthLabel;

    @FXML
    private Label dayLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField monthTextField;

    @FXML
    private GridPane mainGridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* When button is pressed add data to array and close the window */
        submitButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    if (!dayTextField.getText().equals("")) {
                        int day = Integer.parseInt(dayTextField.getText());
                        int month = Integer.parseInt(monthTextField.getText());
                        int year = Integer.parseInt(yearTextField.getText());
                        int score = Integer.parseInt(scoreTextField.getText());
                        MainController.selectedTest.getTests().add(
                                new MedicalTestResult(new Date(day, month, year), score));
                        InputMedicalTestResultScreen.close();
                        MainClass.controller.updateData();
                    }
                }
                
            });
        
        /* When button is pressed close the window */
        cancelButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                InputMedicalTestResultScreen.close();
            }  
        });
    }
    
    
}
