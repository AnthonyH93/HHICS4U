
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
 *  File Name: InputMedicalTestResult
 *  Programmer: 
 *  Date: May 12, 2018
 *  Description:
 */
public class InputMedicalTestResultScreen {
    static Stage stage;
    
    /* Create new window from custom fxml template */
    public InputMedicalTestResultScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("InputMedicalTestResultScreen.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 600, 400);
        stage = new Stage();
        stage.setTitle("Add Medical Result");
        stage.setScene(scene);
        stage.show();
    }
    
    /* Close window */
    public static void close () {
        stage.close();
    }
}
