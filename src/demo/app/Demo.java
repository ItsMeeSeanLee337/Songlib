package demo.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import demo.view.Controller;

public class Demo extends Application {

	Stage mainStage;
	
	public void start(Stage stage) 
		throws Exception {
		mainStage = stage;
		mainStage.setTitle("Tastee sandwich");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/demo/view/demo.fxml"));
		AnchorPane pane = (AnchorPane)loader.load();
		
		Controller controller = loader.getController();
		controller.setMainStage(mainStage);
		
		Scene scene = new Scene(pane, 400, 300);
		mainStage.setScene(scene);
		mainStage.show();		
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}





/*
try {
*/	
/*	
} catch (IOException e) {
	e.printStackTrace();
}
*/