package MainClasses;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class MedicalDefinitionsScreen {
  static Stage stage;
    
  
    public MedicalDefinitionsScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/MedicalUnits.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 600, 400);
        stage = new Stage();
        stage.setTitle("Medical Definitions/Units");
        stage.setScene(scene);
        stage.show();
    }
    
    /* Close window */
     public static void close () {
        stage.close();
        
      
    }
}

