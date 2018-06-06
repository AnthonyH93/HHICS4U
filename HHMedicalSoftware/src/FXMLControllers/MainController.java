package FXMLControllers;

import DataStorage.FileManager;
import DataTypes.Date;
import DataTypes.Flag;
import MainClasses.MedicalFunctions;
import DataTypes.MedicalTestResult;
import DataTypes.MedicalTestType;
import MainClasses.MainClass;
import MainClasses.MainScreen;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private Button addMedicalTestTypeButton;
    
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
                updateData();
            }
            
        });
        addMedicalTestResultButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.addMedicalTestResult();
                updateData();
            }
            
        });
        deleteMedicalTestResultButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                selectedTest.getTests().remove(testDateListView.getSelectionModel().getSelectedItem());
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
         btnOpenDefinitions.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                MedicalFunctions.openDefinitionsScreen();
            }
        });
                
                
                
        btnCloseProgram.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                FileManager.save();
                MainScreen.close();
            }     
        }); 
        sortButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                sortArrays();
                updateData();
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
            updateChart();
        } catch (NullPointerException n) {
            System.out.print("User has not created any results yet.");
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

    private void updateTestResultBox() {
        try {
            StringBuilder output = new StringBuilder();
            output.append("Test:         " + selectedTest.getName());
            output.append("\n");
            output.append("Test Date:    " + selectedResult.getDate());
            output.append("\n\n");
            output.append("Score:        " + selectedResult.getScore());
        
            testResultTextArea.setText(output.toString());
        } catch (NullPointerException e) {
            System.out.println("Result has not been selected.");
        }
    }
    
    public void sortArrays () {
        for (int i = 0; i < testTypes.size(); i++) {
            
            testTypes.get(i).sortTests();
            
                for (int j = i + 1; j < testTypes.size(); j++) {
                    if (testTypes.get(i).getName().compareToIgnoreCase(testTypes.get(j).getName()) > 0) {
                        MedicalTestType temp = testTypes.get(i);
                        testTypes.set(i, testTypes.get(j));
                        testTypes.set(j, temp);
                    }
                }
            }
    }
    
    public void updateChart () {
        testResultChart.getData().clear();
        testResultChart.setTitle(selectedTest.getName());
        
        XYChart.Series chartData = new XYChart.Series();
        chartData.setName("Result Chart");
        
        for (int i = 0; i < selectedTest.getTests().size(); i++) {
            chartData.getData().add(new XYChart.Data(selectedTest.getTests().get(i).getDate().toString(), selectedTest.getTests().get(i).getScore()));
        }
        
        testResultChart.getData().add(chartData);
        System.out.println("called");
    }
}

class resultCell extends ListCell<MedicalTestResult> {
    @Override
    protected void updateItem (MedicalTestResult result, boolean empty) {
        super.updateItem(result, empty);
        setText(result.toString());
        if (result.getFlag() == Flag.green) {
            setTextFill(Color.GREEN);
        } else if (result.getFlag() == Flag.yellow) {
            setTextFill(Color.YELLOW);
        } else {
            setTextFill(Color.RED);
        }
        
    }
}
