/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FXMLControllers;

import MainClasses.HelpScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *  File Name: HelpScreenController
 *  Programmer: 
 *  Date: Jun 18, 2018
 *  Description: This file handles the functions of the help screen.
 */
public class HelpScreenController implements Initializable {
    
    /* Inject all fxml elements */
    @FXML
    private Button closeButton;

    
    /* Initialize close button to close screen when pressed */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                HelpScreen.close();
            }
        });
    }
}
