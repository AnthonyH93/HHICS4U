package FXMLControllers;

//import MainClasses.MedicalDefinitionsScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*public class MedicalUnitsController implements Initializable{
/* Inject all FXML Components */
   /* @FXML
    private Pane UnitsPane;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Button btnCloseScreen;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl8;

    @FXML
    private Label lbl9;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lab2;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect3;

    @FXML
    private Rectangle rect2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* When back button is pressed close window */
        /*btnCloseScreen.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalDefinitionsScreen.close();
            }  
        });
    }*/

