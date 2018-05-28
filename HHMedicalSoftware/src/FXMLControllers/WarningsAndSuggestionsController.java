package FXMLControllers;

import MainClasses.WarningsAndSuggestionsScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class WarningsAndSuggestionsController implements Initializable{
    /* Inject all FXML Components */
    @FXML
    private Button btnBack;

    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;

    @FXML
    private Button btnSearch;

    @FXML
    private Rectangle rectangle3;

    @FXML
    private Rectangle rectangle4;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private TextArea txtSuggestions;

    @FXML
    private Pane mainPane;

    @FXML
    private TextArea txtWarnings;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* When back button is pressed close window */
        btnBack.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                WarningsAndSuggestionsScreen.close();
            }  
        });
        
    }
    
    
}
