package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
				
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/FitnessForYouView.fxml"));
			FitnessForYouController controller = (FitnessForYouController)loader.getController();
			controller.applicationStage = primaryStage;
			Scene scene = new Scene(root,600,400);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Fitness App designed for you");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
