/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  File Name: HelpScreen
 *  Programmer: 
 *  Date: Jun 18, 2018
 *  Description: This file handles opening and closing the help screen.
 */
public class HelpScreen {
    static Stage stage;
    
    /* Create new window from custom fxml template */
    public HelpScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/HelpScreen.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 640, 400);
        stage = new Stage();
        stage.setTitle("Help & Support");
        stage.setScene(scene);
        stage.show();
    }
    
    /* Close window */
    public static void close () {
        stage.close();
    }
}
