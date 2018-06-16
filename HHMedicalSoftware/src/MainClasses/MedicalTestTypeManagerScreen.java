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
 *  File Name: MedicalTestTypeManagerScreen
 *  Programmer: 
 *  Date: Jun 16, 2018
 *  Description:
 */

public class MedicalTestTypeManagerScreen {
    
    static Stage stage;
    
    /* Create new window from custom fxml template */
    public MedicalTestTypeManagerScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/MedicalTestTypeManager.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 600, 400);
        stage = new Stage();
        stage.setTitle("Add Medical Test");
        stage.setScene(scene);
        stage.show();
    }
    
    /* Close window */
    public static void close () {
        stage.close();
    }
    

}
