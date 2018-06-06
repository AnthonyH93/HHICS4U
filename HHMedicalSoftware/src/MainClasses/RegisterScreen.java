/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;

import DataStorage.FileManager;
import static MainClasses.MainClass.controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  File Name: RegisterScreen
 *  Programmer: 
 *  Date: Jun 6, 2018
 *  Description:
 */
public class RegisterScreen {
    static Stage stage;
    
    /* Create new window from custom fxml template */
    public RegisterScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/RegisterScreen.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 640, 400);
        stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }
    
    /* Close window */
    public static void close () {
        stage.close();
    }
}
