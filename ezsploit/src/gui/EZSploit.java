package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EZSploit extends Application{

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root;
		try { // load the fxml file code
			root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not find the fxml file directory");
			return;
		}
		
		Scene mainScene = new Scene(root); // our scene will be the fxml code
		primaryStage.setScene(mainScene); // set the stage to the fxml scene
		primaryStage.sizeToScene(); // size the scene automatically
		primaryStage.setTitle("EZSploit");
		primaryStage.show(); // now show the stage
	}
}
