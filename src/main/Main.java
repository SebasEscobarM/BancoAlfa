package main;

import controller.MainBankWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("../ui/MainBankWindow.fxml"));
		loader.setController(new MainBankWindowController());
		Parent parent=(Parent) loader.load();
		Scene scene=new Scene(parent);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
	}

}
