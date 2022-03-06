package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.BankSystem;
import model.Movement;

public class NewMovementWindowController implements Initializable{

	private ObservableList<String> itms=FXCollections.observableArrayList();
	
    @FXML
    private ComboBox<String> typeCMB;

    @FXML
    private TextField mountTF;

    @FXML
    private TextField commentTF;

    @FXML
    private Button addMovementBTN;
    
    @FXML
    private DatePicker movementDTE;
    
    @FXML
    void addMovement(ActionEvent event) {
    	String type=typeCMB.getSelectionModel().getSelectedItem();
    	double mount=Double.parseDouble(mountTF.getText());
    	String comment=commentTF.getText();
    	LocalDate date=movementDTE.getValue();
    	
    	BankSystem.mvmnts.add(new Movement(type,mount,comment,date));
    	Stage stage=(Stage) this.addMovementBTN.getScene().getWindow();
    	stage.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		itms.add("Gasto");
		itms.add("Ingreso");
		typeCMB.setItems(itms);
	}
}

