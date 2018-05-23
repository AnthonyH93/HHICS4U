package FXMLControllers;

import DataStorage.FileManager;
import MainClasses.MedicalFunctions;
import DataTypes.MedicalTestResult;
import DataTypes.MedicalTestType;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *  File Name: MainController
 *  Date: May 11, 2018
 *  Description: This class serves as the controller of the components of the main screen.
 */


public class MainController implements Initializable{

    /* Inject all FXML Components */
    
    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private BorderPane testResultTextPane;

    @FXML
    private TextField medicalDataLabel;

    @FXML
    private AnchorPane rightContainerPane;

    @FXML
    private Pane topBarPane;

    @FXML
    private SplitPane medicalDataSplitPane;

    @FXML
    private AnchorPane testDateLabelContainer;

    @FXML
    private ImageView logoView;

    @FXML
    private AnchorPane medicalDataLabelContainer;

    @FXML
    public ListView<MedicalTestType> medicalDataListView;

    @FXML
    private AnchorPane testResultTextContainer;

    @FXML
    private AnchorPane medicalDataListContainer;

    @FXML
    private AnchorPane testResultChartContainer;

    @FXML
    private LineChart<?, ?> testResultChart;

    @FXML
    private AnchorPane testDateListContainer;

    @FXML
    private SplitPane testDateSplitPane;

    @FXML
    private TextField testDateLabel;

    @FXML
    private SplitPane leftSplitPane;

    @FXML
    private TextArea testResultTextArea;

    @FXML
    private SplitPane testResultSplitPane;

    @FXML
    private ListView<MedicalTestResult> testDateListView;

    @FXML
    private AnchorPane leftContainerPane;
    
    @FXML
    private Pane bottomPane;

    @FXML
    private Button addMedicalTestTypeButton;
    
    @FXML
    private Button addMedicalTestResultButton;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button btnLaunchWarningsScreen;
    
    @FXML
    private Pane mainPane;
    
    @FXML
    private TextArea txtWarnings;
    
    @FXML
    private TextArea txtSuggestions;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnSearch;
            
    
    public static ArrayList<MedicalTestType> testTypes = new ArrayList<MedicalTestType>();
    public static MedicalTestType selectedTest = null;
    public static MedicalTestResult selectedResult = null;
    
    /* Initialize the components */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        medicalDataListView.getItems().setAll(testTypes);
        //testDateListView.getItems().setAll(selectedTest.getTests());
        addMedicalTestTypeButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.addMedicalTestType();
                updateMedicalTestTypeList();
            }
            
        });
        addMedicalTestResultButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.addMedicalTestResult();
                updateData();
            }
            
        });
        saveButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                FileManager.save();
            }
            
        });
        btnLaunchWarningsScreen.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.openWarningsScreen();
            }
        });
       }
    
    /* Update list view with current array */
    public void updateMedicalTestTypeList () {
        medicalDataListView.getItems().setAll(testTypes);
    }
    public void updateMedicalTestResultList () {
        try {
            testDateListView.getItems().setAll(selectedTest.getTests());
        } catch (NullPointerException n) {
            System.out.print("User has not created any results yet.");
        }
    }
    
    /* Update all non-static objects on the screen */
    public void updateData () {
        updateMedicalTestTypeList();
        updateMedicalTestResultList();
    }
    
    /* Define handler for when test type list is clicked */
    public void medicalTestTypeListClicked (MouseEvent event) {
        selectedTest = medicalDataListView.getSelectionModel().getSelectedItem();
        updateMedicalTestResultList();
    }
    
    /* Define handler for when test type list is clicked */
    public void medicalTestResultListClicked (MouseEvent event) {
        selectedResult = testDateListView.getSelectionModel().getSelectedItem();
        updateTestResultBox();
    }

    private void updateTestResultBox() {
        try {
            StringBuilder output = new StringBuilder();
            output.append("Test:         " + selectedTest.getName());
            output.append("\n");
            output.append("Description: " + selectedTest.getDescription());
            output.append("\n");
            output.append("Test Date:    " + selectedResult.getDate());
            output.append("\n\n");
            output.append("Score:        " + selectedResult.getScore());
        
            testResultTextArea.setText(output.toString());
        } catch (NullPointerException e) {
            System.out.println("Result has not been selected.");
        }
    }

}

