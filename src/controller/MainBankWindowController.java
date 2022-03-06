package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.BankSystem;
import model.Movement;

public class MainBankWindowController implements Initializable{

    @FXML
    private MenuItem addMovementMNU;

    @FXML
    private MenuItem exitMNU;

    @FXML
    private TableView<Movement> movimientosTBL;

    @FXML
    private TableColumn<Movement, String> tipoCLM;

    @FXML
    private TableColumn<Movement, Double> mountCLM;

    @FXML
    private TableColumn<Movement, String> commentCLM;

    @FXML
    private TableColumn<Movement, LocalDate> dateCLM;

    @FXML
    private DatePicker initDate;

    @FXML
    private DatePicker finishDate;

    @FXML
    private Button filterBTN;

    @FXML
    private Button addMovementBTN;
    
    @FXML
    private Button deleteBTN;
    
    @FXML
    private Button deleteFltBTN;
    
    @FXML
    private Label ingrLBL;

    @FXML
    private Label gstsLBL;

    @FXML
    private Label totalLBL;
    
    private Movement movementClicked;
    
    private ObservableList<Movement> fltr=FXCollections.observableArrayList();
    
    @FXML
    void addMovement(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(Main.class.getResource("../ui/NewMovementWindow.fxml"));
		loader.setController(new NewMovementWindowController());
		Parent parent=(Parent) loader.load();
		Scene scene=new Scene(parent);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void clearFilter(ActionEvent event) {
    	
    	movimientosTBL.setItems(BankSystem.mvmnts);
    	fltr.clear();
    	refreshLBLs();
    }
    
    @FXML
    void exit(ActionEvent event) {
    	Platform.exit();
    	System.exit(0);
    }

    @FXML
    void filterData(ActionEvent event) {
    	
    	movimientosTBL.setItems(fltr);
    	LocalDate init=initDate.getValue();
    	LocalDate finsh=finishDate.getValue();
    	
    	for(Movement m:BankSystem.mvmnts) {
    		if(m.getDate().isAfter(init) && m.getDate().isBefore(finsh)) {
    			fltr.add(m);
    		}
    	}
    	refreshLBLs();
    }
    
    @FXML
    void deleteMovement(ActionEvent event) {
    	BankSystem.mvmnts.remove(movementClicked);
    }

    public void refreshLBLs() {
    	BankSystem.setBalanceValues(movimientosTBL.getItems());
    	
    	ingrLBL.setText(String.valueOf(BankSystem.earnings));
		gstsLBL.setText(String.valueOf(BankSystem.expenses));
		totalLBL.setText(String.valueOf(BankSystem.totalBalance));
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tipoCLM.setCellValueFactory(new PropertyValueFactory<>("type"));
		mountCLM.setCellValueFactory(new PropertyValueFactory<>("mount"));
		commentCLM.setCellValueFactory(new PropertyValueFactory<>("comment"));
		dateCLM.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		movimientosTBL.setItems(BankSystem.mvmnts);
		//Revisar si puedo manejar esto como una observable list o un objeto q se actualicec solo
		ingrLBL.setText(String.valueOf(BankSystem.earnings));
		gstsLBL.setText(String.valueOf(BankSystem.expenses));
		totalLBL.setText(String.valueOf(BankSystem.totalBalance));
		
		movimientosTBL.setOnMouseClicked(event->{
			movementClicked=movimientosTBL.getSelectionModel().getSelectedItem();
			refreshLBLs();
		});
		
	}

}