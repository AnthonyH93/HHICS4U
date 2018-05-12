
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
public class InputMedicalTestDataScreenController implements Initializable {
    
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* When button is pressed add data to array and close the window */
        submitButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    if (!nameTextField.getText().equals("")) {
                        MainController.testTypes.add(new MedicalTestType(nameTextField.getText(), ""));
                        InputMedicalTestDataScreen.close();
                        MainClass.controller.updateMedicalTestTypeList();
                    }
                }
                
            });
        
        /* When button is pressed close the window */
        cancelButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                InputMedicalTestDataScreen.close();
            }  
        });
    }
    
    
}
