package MainClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataStorage.FileManager;
import FXMLControllers.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *  File Name: MainClass
 *  Date: May 11, 2018
 *  Description: This file is the main class of the program and loads the
 *  main screen when the program is started.
 */

public class MainClass extends Application {
    
    /* Create variable to hold the controller of the scene */
    public static MainController controller;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        /* Create new window from custom fxml template */
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/HHMedicalSoftware.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 500);
    
        primaryStage.setTitle("HH Medical Software");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        controller = loader.getController();
        
        FileManager.open();
        controller.updateData();
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent> () {
            @Override
            public void handle(WindowEvent event) {
                FileManager.save();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
