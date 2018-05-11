import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;

public class MainController implements Initializable{

    @FXML
    private Label titleLabel;

    @FXML
    private TableColumn<?, ?> typeTable;

    @FXML
    private ListView<String> listView;

    
    public void listClicked(ActionEvent event) {
        listView.getItems().addAll("hi");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(FXCollections.observableArrayList("July 3, 2004"));
        
    }

}

