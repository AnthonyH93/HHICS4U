/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * 
 */
public class MainClass extends Application {
    
    public static MainController controller;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        FXMLLoader loader = new FXMLLoader (getClass().getResource("HHMedicalSoftware.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 500);
    
        primaryStage.setTitle("HH Medical Software");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        controller = loader.getController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
