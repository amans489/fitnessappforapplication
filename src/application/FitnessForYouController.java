

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FitnessForYouController {
	Stage applicationStage;
    @FXML
    private ChoiceBox<?> weekExerciseChoiceBox;
    
    @FXML
    private TextField runningDistanceTextField;

   @FXML
   private Label runningLabel;
   
   @FXML
   private Label caloriesBurned;
   
   @FXML
   private Button calculate;

    @FXML
    void caloriesBurntDisplay(ActionEvent event) {
    	System.out.println("Calories burnt Displayed");
    	Scene caloriesBurntScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(caloriesBurntScene);
    }

    @FXML
    void workoutDisplay(ActionEvent event) {
    	
    }
   
    @FXML 
    void userInfo(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox container = new VBox();
    }
 //this method will set the scene that displays the textbox for distance ran, user can enter the distance
 //scene has button to calculate the calories burned and label to display the calories burned
    @FXML
    void running (ActionEvent event) {
    Scene mainScene = applicationStage.getScene();
    
   VBox runningContainer = new VBox();
   
// text box with its label in a h box     
  HBox distanceR = new HBox();
    Label runningLabel = new Label("Distance Ran in Kilometers");
    TextField runningDistanceTextField = new TextField();
// adding label and text box to H box                 
    distanceR.getChildren().addAll(runningLabel, runningDistanceTextField);
// adding the H box to the V box                      
    runningContainer.getChildren().add(distanceR);
    
 Label caloriesBurned = new Label("Calories Burned: ");

    runningContainer.getChildren().addAll(caloriesBurned, calculate);
    
   Scene runningScene = new Scene(runningContainer);
    applicationStage.setScene(runningScene);
    }
// this method will calculate the calories burned running using the calculate class
    void calculateCalories (Scene runningScene ) {
    //need to add a get value for the weight
int MET = 8;
    double bodyWeight = 0.0;
    double totalCaloriesBurned = 0.0;

    String Distance=runningDistanceTextField.getText();
    Double distanceRan = Double.parseDouble(Distance);
 //this invokes the class that calculates the calories burned
    CountR caloriesR = new CountR(MET, distanceRan, bodyWeight);
 //calories will be caluclated in the Countr class using the getCalorieCalc method
  
  totalCaloriesBurned += caloriesR.getCalorieCalc();
 //updatelabel
  caloriesBurned.setText(String.format("Calories Burned: "+totalCaloriesBurned));
   
    }

}