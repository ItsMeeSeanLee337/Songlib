// Sean Lee & Carlos Aguilar
package app;
import view.*;

import java.io.*;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.SonglibController;

public class Songlib extends Application {

	Stage mainStage;
	
	public void start(Stage stage) throws IOException {
		mainStage = stage;
		mainStage.setTitle("Song Library");
	
		// Load the FXML file into a VBox
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SonglibView.fxml"));
		VBox root = loader.load();
	
		// Set the main stage for the controller
		SonglibController controller = loader.getController();
		controller.setMainStage(mainStage);
	
		// Show the scene
		Scene scene = new Scene(root, 700, 400);
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