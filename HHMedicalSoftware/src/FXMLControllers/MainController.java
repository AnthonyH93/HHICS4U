package FXMLControllers;

import DataStorage.FileManager;
import DataTypes.Date;
import DataTypes.Flag;
import MainClasses.MedicalFunctions;
import DataTypes.MedicalTestResult;
import DataTypes.MedicalTestType;
import MainClasses.HelpScreen;
import MainClasses.MainClass;
import MainClasses.MainScreen;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
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
import javafx.scene.paint.Color;
import javafx.util.Callback;

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
    private LineChart<String, Number> testResultChart;

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
    private Button medicalTestTypeManagerButton;
    
    @FXML
    private Button addMedicalTestResultButton;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private Button btnLaunchWarningsScreen;
    
    @FXML
    private Button deleteMedicalTestResultButton;
    
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
    
    @FXML
    private Button btnCloseProgram;
            
    @FXML
    private Button sortButton;
    
    @FXML
    private CategoryAxis dateAxis;
    
    @FXML
    private NumberAxis scoreAxis;
    
    @FXML
    private Button btnOpenDefinitions;
    
    @FXML
    private Button helpButton;
    
    /* Create the main array to hold all of the test types of the program */
    public static ArrayList<MedicalTestType> testTypes = new ArrayList<MedicalTestType>();
    
    /* Create two variables to hold the current test and result that have been selected */
    public static MedicalTestType selectedTest = null;
    public static MedicalTestResult selectedResult = null;
    
    /* Initialize the components */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* Set the medical data list view to show all of the test types */
        medicalDataListView.getItems().setAll(testTypes);
        
        helpButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new HelpScreen();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        /* Open help page when help button is pressed */
        medicalTestTypeManagerButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.openMedicalTestTypeManager();
                updateData();
            }
            
        });
        
        /* When add medical test button is pressed open add medical test window and update the data */
        addMedicalTestResultButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.addMedicalTestResult();
                updateData();
            }
            
        });
        
        /* When delete medical test button is pressed find the selected test and remove it from the array */
        deleteMedicalTestResultButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                selectedTest.getTests().remove(testDateListView.getSelectionModel().getSelectedItem());
                updateData();
            }
            
        });
        
        /* When save button is pressed call the save function in FileManager class */
        saveButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                FileManager.save();
            }
            
        });
        
        /* When warning screen button is pressed open the warning screen */
        btnLaunchWarningsScreen.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.openWarningsScreen();
            }
        });
        
        /* When the definitions button is pressed open the definitions screen */
         btnOpenDefinitions.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.openDefinitionsScreen();
            }
        });

        /* When the close button is pressed save the data and close the program */
        btnCloseProgram.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                FileManager.save();
                MainScreen.close();
            }     
        }); 
        
        /* Whent the sort button is pressed call the sort arrays function and update the data */
        sortButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                sortArrays();
                updateData();
            }
        });
    }
    
    /* Update the test type list view with current array */
    public void updateMedicalTestTypeList () {
        medicalDataListView.getItems().setAll(testTypes);
    }
    
    /* Update the result list view with current arrays */
    public void updateMedicalTestResultList () {
        try {
            testDateListView.getItems().setAll(selectedTest.getTests());
        } catch (NullPointerException e) {
            System.out.println("User has not selected a test yet.");
        }
    }
    
    /* Update all non-static objects on the screen */
    public void updateData () {
        updateMedicalTestTypeList();
        updateMedicalTestResultList();
        sortArrays();
        try {
            updateChart();
        } catch (NullPointerException e) {
            System.out.println("Test has not been selected yet.");
        }
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

    /* This function updates the text box with the information of the current selected test */
    private void updateTestResultBox() {
        
        /* Surround with try-catch to catch null pointer if a test has not been selected by user */
        try {
            /* Create a string with all information */
            StringBuilder output = new StringBuilder();
            output.append("Test:         " + selectedTest.getName());
            output.append("\n");
            output.append("Test Date:    " + selectedResult.getDate());
            output.append("\n\n");
            output.append("Score:        " + selectedResult.getScore());
        
            /* Output string to text area */
            testResultTextArea.setText(output.toString());
        } catch (NullPointerException e) {
            System.out.println("Result has not been selected.");
        }
    }
    
    /* This function sorts all of the arrays in the main array */
    public void sortArrays () {
        /* Loop through all of the test types within the main array */
        for (int i = 0; i < testTypes.size(); i++) {
            
            /* Call each test type's sort function to sort the tests within them */
            testTypes.get(i).sortTests();
            
                /* Use a selection sort algorithm to sort the test types in alphabetical order */
                for (int j = i + 1; j < testTypes.size(); j++) {
                    if (testTypes.get(i).getName().compareToIgnoreCase(testTypes.get(j).getName()) > 0) {
                        MedicalTestType temp = testTypes.get(i);
                        testTypes.set(i, testTypes.get(j));
                        testTypes.set(j, temp);
                    }
                }
            }
    }
    
    /* This method updates the graph under the text area */
    public void updateChart () {
        /* Clear the previous chart data and set title to name of selected test */
        testResultChart.getData().clear();
        testResultChart.setTitle(selectedTest.getName());
        
        /* Set the type of chart data to be an XY series chart */
        XYChart.Series chartData = new XYChart.Series();
        chartData.setName("Result Chart");
        
        /* Loop through tests of selected test type and add dates to x-axis and scores to y-axis */
        for (int i = 0; i < selectedTest.getTests().size(); i++) {
            chartData.getData().add(new XYChart.Data(selectedTest.getTests().get(i).getDate().toString(), selectedTest.getTests().get(i).getScore()));
        }
        
        /* Add the data to the chart */
        testResultChart.getData().add(chartData);
    }
}

