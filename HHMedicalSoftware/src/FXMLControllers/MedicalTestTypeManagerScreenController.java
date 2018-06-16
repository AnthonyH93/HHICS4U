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
import MainClasses.MainClass;
import MainClasses.MedicalTestTypeManagerScreen;
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
import javafx.util.StringConverter;

/**
 *  File Name: MedicalTestTypeManagerScreenController
 *  Programmer: 
 *  Date: May 23, 2018
 *  Description: This screen allows the user to add or delete test types in the program.
 */
public class MedicalTestTypeManagerScreenController implements Initializable{
    
    /* Inject all FXML elements */
    
    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Button submitButton;

    @FXML
    private Pane topBarPane;

    @FXML
    private TableColumn<MedicalTestType, Double> greenMinimumColumn;

    @FXML
    private Label titleLabel;

    @FXML
    private Pane bottomPane;

    @FXML
    private ImageView logoView;

    @FXML
    private TableColumn<MedicalTestType, Double> yellowMaximumColumn;

    @FXML
    private Button cancelButton;

    @FXML
    private TableColumn<MedicalTestType, String> nameColumn;

    @FXML
    private TableColumn<MedicalTestType, Double> greenMaximumColumn;

    @FXML
    private TableColumn<MedicalTestType, Double> yellowMinimumColumn;

    @FXML
    private TableColumn<MedicalTestType, Double> greenColumn;

    @FXML
    private VBox tableContainer;

    @FXML
    private TableColumn<MedicalTestType, Double> yellowColumn;

    @FXML
    private TableView<MedicalTestType> testTypeTable;
    
    ObservableList<MedicalTestType> tests;
    
    @FXML
    private Button addButton;
    
    @FXML
    private Button deleteButton;

    /* Initialize the elements */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        /* Create an observable array list that is equal to the main array */
        tests = FXCollections.observableArrayList(MainController.testTypes);
       
        /* Make the cells text fields */
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        greenMinimumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double> () {
            @Override
            public String toString(Double object) {
                return object.toString();
            }

            @Override
            public Double fromString(String string) {
                return Double.parseDouble(string);
            }
            
        }));
        yellowMaximumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double> () {
            @Override
            public String toString(Double object) {
                return object.toString();
            }

            @Override
            public Double fromString(String string) {
                return Double.parseDouble(string);
            }
            
        }));
        greenMaximumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double> () {
            @Override
            public String toString(Double object) {
                return object.toString();
            }

            @Override
            public Double fromString(String string) {
                return Double.parseDouble(string);
            }
            
        }));
        yellowMinimumColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double> () {
            @Override
            public String toString(Double object) {
                return object.toString();
            }

            @Override
            public Double fromString(String string) {
                return Double.parseDouble(string);
            }
            
        }));
        
        /* When the column has been edited and the user pressed enter, set the cell to this new value */
        nameColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, String> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue())
                );
        
        /* When the column has been edited and the user pressed enter, set the cell to this new value */
        greenMinimumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Double> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGreenMinimumScore(t.getNewValue())
                );
        
        /* When the column has been edited and the user pressed enter, set the cell to this new value */
        greenMaximumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Double> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGreenMaximumScore(t.getNewValue())
                );
        
        /* When the column has been edited and the user pressed enter, set the cell to this new value */
        yellowMinimumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Double> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYellowMinimumScore(t.getNewValue())
                );
        
        /* When the column has been edited and the user pressed enter, set the cell to this new value */
        yellowMinimumColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<MedicalTestType, Double> t) ->
                    ( t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYellowMaximumScore(t.getNewValue())
                );
        
        /* Set each cell value to the property it corresponds to in the test type object */
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, String>("name"));
        greenMinimumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Double>("greenMinimumScore"));
        greenMaximumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Double>("greenMaximumScore"));
        yellowMinimumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Double>("yellowMinimumScore"));
        yellowMaximumColumn.setCellValueFactory(
                new PropertyValueFactory<MedicalTestType, Double>("yellowMaximumScore"));
        
        /* Set the table to editable */
        testTypeTable.setEditable(true);
        
        /* Set the table items to the tests */
        testTypeTable.setItems(tests);
        
        /* When the submit button is pressed get data from the table and set the main array to it */
        submitButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    tests = testTypeTable.getItems();
                    MainController.testTypes.clear();
                    MainController.testTypes.addAll(tests);
                    MedicalTestTypeManagerScreen.close();
                    MainClass.controller.updateData();
                }
                
            });
        
        /* When button is pressed create a new item in the table */
        addButton.setOnAction(new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    testTypeTable.getItems().add(new MedicalTestType("", 0, 0, 0, 0));
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
                MedicalTestTypeManagerScreen.close();
            }  
        });
    }
    
    
}
