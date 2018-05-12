import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/* This class serves as the controller of the components of the main screen */

public class MainController implements Initializable{

    /* Inject all FXML Components */
    
    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Pane testResultTextPane;

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
    private ListView<String> testDateListView;

    @FXML
    private AnchorPane leftContainerPane;
    
    @FXML
    private Pane bottomPane;

    @FXML
    private Button addMedicalTestTypeButton;
    
    public static ArrayList<MedicalTestType> testTypes = new ArrayList<MedicalTestType>();
    
    /* Initialize the components */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        medicalDataListView.getItems().setAll(testTypes);
        addMedicalTestTypeButton.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                TestFunctions.addMedicalTestType();
                updateMedicalTestTypeList();
            }
            
        });
    }
    
    /* Update list view with current array */
    public void updateMedicalTestTypeList () {
        medicalDataListView.getItems().setAll(testTypes);
    }

}
