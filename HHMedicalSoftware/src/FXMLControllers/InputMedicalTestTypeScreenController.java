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
    
    /*
    <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<MedicalTypes>
    <TestType>
        <Name>Calcium (mg/dL)</Name>
        <Description/>
        <GreenMinimumScore>9</GreenMinimumScore>
        <GreenMaximumScore>11</GreenMaximumScore>
        <YellowMinimumScore>8</YellowMinimumScore>
        <YellowMaximumScore>12</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Chloride (mEq/L)</Name>
        <Description/>
        <GreenMinimumScore>98</GreenMinimumScore>
        <GreenMaximumScore>106</GreenMaximumScore>
        <YellowMinimumScore>90</YellowMinimumScore>
        <YellowMaximumScore>115</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Hemoglobin (g/dL)</Name>
        <Description/>
        <GreenMinimumScore>12</GreenMinimumScore>
        <GreenMaximumScore>18</GreenMaximumScore>
        <YellowMinimumScore>10</YellowMinimumScore>
        <YellowMaximumScore>20</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Phosphorus (mg/dL)</Name>
        <Description/>
        <GreenMinimumScore>3</GreenMinimumScore>
        <GreenMaximumScore>4</GreenMaximumScore>
        <YellowMinimumScore>2</YellowMinimumScore>
        <YellowMaximumScore>5</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Platlets (mL)</Name>
        <Description/>
        <GreenMinimumScore>150000</GreenMinimumScore>
        <GreenMaximumScore>400000</GreenMaximumScore>
        <YellowMinimumScore>100000</YellowMinimumScore>
        <YellowMaximumScore>500000</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Potassium (mEq/L)</Name>
        <Description/>
        <GreenMinimumScore>4</GreenMinimumScore>
        <GreenMaximumScore>5</GreenMaximumScore>
        <YellowMinimumScore>3</YellowMinimumScore>
        <YellowMaximumScore>6</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>RBC (million cmm)</Name>
        <Description/>
        <GreenMinimumScore>4</GreenMinimumScore>
        <GreenMaximumScore>6</GreenMaximumScore>
        <YellowMinimumScore>7</YellowMinimumScore>
        <YellowMaximumScore>3</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Sodium (mEq/L)</Name>
        <Description/>
        <GreenMinimumScore>135</GreenMinimumScore>
        <GreenMaximumScore>145</GreenMaximumScore>
        <YellowMinimumScore>134</YellowMinimumScore>
        <YellowMaximumScore>150</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>Sugar (mg/dL)</Name>
        <Description/>
        <GreenMinimumScore>70</GreenMinimumScore>
        <GreenMaximumScore>99</GreenMaximumScore>
        <YellowMinimumScore>60</YellowMinimumScore>
        <YellowMaximumScore>115</YellowMaximumScore>
    </TestType>
    <TestType>
        <Name>WBC (per ccm)</Name>
        <Description/>
        <GreenMinimumScore>4300</GreenMinimumScore>
        <GreenMaximumScore>10800</GreenMaximumScore>
        <YellowMinimumScore>3800</YellowMinimumScore>
        <YellowMaximumScore>12000</YellowMaximumScore>
    </TestType>
</MedicalTypes>
    */
    
}
