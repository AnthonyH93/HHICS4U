
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

/**
 *  File Name: InputMedicalTestDataScreen
 *  Programmer: 
 *  Date: May 11, 2018
 *  Description:
 */
public class InputMedicalTestDataScreen {

    public InputMedicalTestDataScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("InputMedicalTestDataScreen.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("HH Medical Software");
        stage.setScene(scene);
        stage.show();
    }

}
