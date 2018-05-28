/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FXMLControllers;

import DataTypes.Date;
import DataTypes.MedicalTestResult;
import DataTypes.MedicalTestType;
import MainClasses.InputMedicalTestResultScreen;
import MainClasses.InputMedicalTestTypeScreen;
import MainClasses.MainClass;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *  File Name: MedicalTestTypeManagerScreenController
 *  Programmer: 
 *  Date: May 23, 2018
 *  Description:
 */
public class MedicalTestTypeManagerScreenController implements Initializable{
    
    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Button submitButton;

    @FXML
    private Pane topBarPane;

    @FXML
    private TableColumn<MedicalTestType, Integer> greenMinimumColumn;

    @FXML
    private Label titleLabel;

    @FXML
    private Pane bottomPane;

    @FXML
    private ImageView logoView;

    @FXML
    private TableColumn<MedicalTestType, Integer> yellowMaximumColumn;

    @FXML
    private Button cancelButton;

    @FXML
    private TableColumn<MedicalTestType, String> nameColumn;

    @FXML
    private TableColumn<MedicalTestType, Integer> greenMaximumColumn;

    @FXML
    private TableColumn<MedicalTestType, Integer> yellowMinimumColumn;

    @FXML
    private TableColumn<MedicalTestType, Integer> greenColumn;

    @FXML
    private VBox tableContainer;

    @FXML
    private TableColumn<MedicalTestType, Integer> yellowColumn;

    @FXML
    private TableView<MedicalTestType> testTypeTable;
    
    ObservableList<MedicalTestType> tests;
    
    @FXML
    private Button addButton;
    
    @FXML
    private Button deleteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        tests = FXCollections.observableArrayList(MainController.testTypes);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       
        
        nameColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, String> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue())
                );
        
        greenMinimumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Integer> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGreenMinimumScore(t.getNewValue())
                );
        
        greenMaximumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Integer> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGreenMaximumScore(t.getNewValue())
                );
        
        yellowMinimumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Integer> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYellowMinimumScore(t.getNewValue())
                );
        
        yellowMinimumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Integer> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYellowMaximumScore(t.getNewValue())
                );
        
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, String>("name"));
        greenMinimumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Integer>("greenMinimumScore"));
        greenMaximumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Integer>("greenMaximumScore"));
        yellowMinimumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Integer>("yellowMinimumScore"));
        yellowMaximumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Integer>("yellowMaximumScore"));
        
        testTypeTable.setEditable(true);
        testTypeTable.setItems(tests);
        
        submitButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    tests = testTypeTable.getItems();
                    MainController.testTypes.clear();
                    MainController.testTypes.addAll(tests);
                    InputMedicalTestTypeScreen.close();
                    MainClass.controller.updateData();
                }
                
            });
        
        /* When button is pressed create a new item in the table */
        addButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    testTypeTable.getItems().add(new MedicalTestType("", "", 0, 0, 0, 0));
                }
            });
        
        /* When button is pressed remove data from array */
        deleteButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    testTypeTable.getItems().remove(testTypeTable.getSelectionModel().getSelectedItem());
                }
            });
        
        /* When button is pressed close the window */
        cancelButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                InputMedicalTestTypeScreen.close();
            }  
        });
    }
    
    
}
