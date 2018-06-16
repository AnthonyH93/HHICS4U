/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;

import DataStorage.FileManager;
import static MainClasses.MainClass.controller;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *  File Name: MainScreen
 *  Programmer: 
 *  Date: Jun 6, 2018
 *  Description: This file opens the main screen and automatically calls the File Manager
 *  open function.
 */

public class MainScreen {
    static Stage stage;
    
    /* Create new window from custom fxml template */
    public MainScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/HHMedicalSoftware.fxml"));
        Parent root = loader.load();
        
        /* Set the main controller to this one */
        MainClass.controller = loader.getController();
        
        FileManager.open();
        controller.updateData();
        
        /* When the program is closed automatically save the file */
        /*
        stage.setOnCloseRequest(new EventHandler<WindowEvent> () {
            @Override
            public void handle(WindowEvent event) {
                FileManager.save();
            }
            
        }); */
        
        Scene scene = new Scene(root, 800, 500);
        stage = new Stage();
        stage.setTitle("H&H Medical Software");
        stage.setScene(scene);
        stage.show();
    }
    
    /* Close window */
    public static void close () {
        stage.close();
    }
}
