
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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
	private TextField runningDurationTextField;
	@FXML
	private Label runningLabel;
	@FXML
	private Label caloriesBurnedR;
	@FXML
	private Button calculateR;

	@FXML 
	private Label joggingLabel;
	@FXML 
	private Label caloriesBurnedJ;
	@FXML 
	private Button calculateJ;
	@FXML 
	private TextField joggingDurationTextField;

	@FXML 
	private Label caloriesBurnedW;
	@FXML 
	private Button calculateW;
	@FXML 
	private Label walkingLabel;
	@FXML 
	private TextField walkingDurationTextField;
	
	@FXML 
	private Button runningButton;
	@FXML 
	private TextField weightTextField;

	@FXML
	void bmiDisplay(ActionEvent event) {
		
	
	}

	@FXML
	void workoutDisplay(ActionEvent event) {
		
	}


	@FXML
	void userInfo(ActionEvent event){
//RUNNING SCENE 		
		VBox runningContainer = new VBox();
		
		Scene runningScene = new Scene(runningContainer);
		
		//runningButton.setOnAction(e-> applicationStage.setScene(runningScene));

		// text box with its label in a h box     
		HBox durationR = new HBox();
		Label runningLabel = new Label("Duration Ran");
		
		TextField runningDurationTextField = new TextField();
		// adding label and text box to H box                 
		durationR.getChildren().addAll(runningLabel, runningDurationTextField);
		// adding the H box to the V box                      
		runningContainer.getChildren().add(durationR);

		Label caloriesBurnedR = new Label("Calories Burned: ");

		Button calculateR = new Button ("Calculate Calories Burned");
		calculateR.setOnAction(e -> calculateCaloriesR(runningScene));
		runningContainer.getChildren().addAll(caloriesBurnedR, calculateR);
//JOGGING
		VBox joggingContainer = new VBox();
		
		Scene joggingScene = new Scene(joggingContainer);
		// text box with its label in a h box     
		HBox durationJ = new HBox();
		Label joggingLabel = new Label("How long did you jog?");
		TextField joggingDurationTextField = new TextField();
		// adding label and text box to H box                 
		durationJ.getChildren().addAll(joggingLabel, joggingDurationTextField);
		// adding the H box to the V box                      
		joggingContainer.getChildren().add(durationJ);

		Label caloriesBurnedJ = new Label("Calories Burned: ");
		Button calculateJ = new Button("Calculate Calories Burned");
		calculateJ.setOnAction(e-> calculateCaloriesJ(joggingScene));
		joggingContainer.getChildren().addAll(caloriesBurnedJ, calculateJ);

		
//WALKING
		VBox walkingContainer = new VBox();
		
		Scene walkingScene = new Scene(walkingContainer);

		// text box with its label in a h box     
		HBox durationW = new HBox();
		Label walkingLabel = new Label("Distance Ran in Kilometers");
		
		TextField walkingDurationTextField = new TextField();
		// adding label and text box to H box                 
		durationW.getChildren().addAll(walkingLabel, walkingDurationTextField);
		// adding the H box to the V box                      
		walkingContainer.getChildren().add(durationW);

		Label caloriesBurnedW = new Label("Calories Burned: ");

		Button calculateW = new Button("Calculate Calories Burned");
		calculateW.setOnAction(e->calculateCaloriesW(walkingScene));
		
		walkingContainer.getChildren().addAll(caloriesBurnedW, calculateW);

		
//MARZIAS SCENE
		//https://jenkov.com/tutorials/javafx/choicebox.html
		String dayOfWeek = (String) weekExerciseChoiceBox.getValue();
		//String height = (String) heightTextfield.getText();
		//String weight =  (String) weightTextfield.getText();

		VBox container = new VBox(10);

		//Scene userInfoScene = new Scene(new Label(("Enter Information"),(container)));
		Scene userInfoScene = new Scene(container,600,400);
		
		
		
		applicationStage.setScene(userInfoScene);
		applicationStage.setTitle("Enter User Information");
		// ChoiceBox weekExerciseChoiceBox = new ChoiceBox();
		//weekExerciseChoiceBox.setOnAction()
		Label dayOfWorkout = new Label("Day of the Week: " + dayOfWeek);
		Label typeOfWorkout = new Label("Choose a Type of Workout: ");
		
		Button walkingButton = new Button("Walking");
		walkingButton.setOnAction(e-> applicationStage.setScene(walkingScene));
		
		
		//walkingButton.setOnAction(new CountW);
		
		Button joggingButton = new Button("Jogging");
		//joggingButton.setOnAction(new CountJ);
		joggingButton.setOnAction(e-> applicationStage.setScene(joggingScene));
		Button runningButton = new Button("Running");
		//runningButton.setOnAction(new CountR)
		runningButton.setOnAction(e-> applicationStage.setScene(runningScene));
		
		TextField weightTextfield = new TextField();
		TextField heightTextfield = new TextField();

		Label heightLabel = new Label("Enter Height:  ");
		Label weightLabel = new Label("Enter Weight: ");
		HBox heightBox = new HBox(7);
		heightBox.getChildren().addAll(heightLabel,heightTextfield);

		HBox weightBox = new HBox(7);
		weightBox.getChildren().addAll(weightLabel,weightTextfield);

		container.setPadding(new Insets(0,5,0,5));
		container.getChildren().addAll(dayOfWorkout,typeOfWorkout, walkingButton, joggingButton,
				runningButton, heightBox, weightBox);
		
		
		


	}

	

//this method will set the scene that displays the textbox for distance ran, user can enter the distance
//scene has button to calculate the calories burned and label to display the calories burned
//RUNNING
//@FXML
//void running (ActionEvent event) {
	
	//Scene mainScene = applicationStage.getScene();

	//VBox runningContainer = new VBox();
	
	//Scene runningScene = new Scene(runningContainer);
	
	//runningButton.setOnAction(e-> applicationStage.setScene(runningScene));

	// text box with its label in a h box     
	// durationR = new HBox();
	//Label runningLabel = new Label("Distance Ran in Kilometers");
	//TextField runningDurationTextField = new TextField();
	// adding label and text box to H box                 
	//durationR.getChildren().addAll(runningLabel, runningDurationTextField);
	// adding the H box to the V box                      
	//runningContainer.getChildren().add(durationR);

	//Label caloriesBurnedR = new Label("Calories Burned: ");

	//Button calculateR = new Button ("Calculate Calories Burned");

	//runningContainer.getChildren().addAll(caloriesBurnedR, calculateR);

	//Scene runningScene = new Scene(runningContainer);
	
	//runningButton.setOnAction(e -> applicationStage.setScene(runningScene));
	//applicationStage.setScene(runningScene);
//}
// this method will calculate the calories burned running using the calculate class
double totalCaloriesBurnedR = 0.0;
void calculateCaloriesR (Scene runningScene) {
	//need to add a get value for the weight
	int METR = 8;
	double bodyWeightR = 0.0;
	double totalCaloriesBurnedR = 0.0;

	String DurationR= runningDurationTextField.getText();
	Double durationRan = Double.parseDouble(DurationR);
	
	String BWR = weightTextField.getText();
	bodyWeightR = Double.parseDouble(BWR);
	//this invokes the class that calculates the calories burned
	CountR caloriesR = new CountR(METR, durationRan,bodyWeightR );
	//calories will be caluclated in the Countr class using the getCalorieCalc method

	totalCaloriesBurnedR += caloriesR.getCalorieCalc();
	//updatelabel
	caloriesBurnedR.setText(String.format("Calories Burned: "+totalCaloriesBurnedR));

}

//JOGGING 
//@FXML
//void jogging (ActionEvent event) {
	//Scene mainScene = applicationStage.getScene();

	//VBox joggingContainer = new VBox();

	// text box with its label in a h box     
	//HBox durationJ = new HBox();
	//Label joggingLabel = new Label("Distance Ran in Kilometers");
	//TextField joggingDurationTextField = new TextField();
	// adding label and text box to H box                 
	//durationJ.getChildren().addAll(joggingLabel, joggingDurationTextField);
	// adding the H box to the V box                      
	//joggingContainer.getChildren().add(durationJ);

	//Label caloriesBurnedJ = new Label("Calories Burned: ");
	//Button calculateJ = new Button("Calculate Calories Burned");

	//joggingContainer.getChildren().addAll(caloriesBurnedJ, calculateJ);

	//Scene joggingScene = new Scene(joggingContainer);
	//applicationStage.setScene(joggingScene);
//}
double totalCaloriesBurnedJ = 0.0;
void calculateCaloriesJ (Scene joggingScene) {
	//need to add a get value for the weight
	int METJ = 7;
	double bodyWeightJ = 0.0;
	double totalCaloriesBurnedJ = 0.0;

	String DurationJ=joggingDurationTextField.getText();
	System.out.println("jog duration" + DurationJ);
	Double durationJog = Double.parseDouble(DurationJ);
	
	String BWJ = weightTextField.getText();
	System.out.println("weight:"+ BWJ);
	bodyWeightJ = Double.parseDouble(BWJ);
	//this invokes the class that calculates the calories burned
	//have to add soemthing the get the bodyweight 
	CountJ caloriesJ = new CountJ(METJ, durationJog, bodyWeightJ);
	//calories will be caluclated in the Countr class using the getCalorieCalc method

	totalCaloriesBurnedJ += caloriesJ.getCalorieCalc();
	//updatelabel
	caloriesBurnedJ.setText(String.format("Calories Burned: "+totalCaloriesBurnedJ));

}	

//WALKING 
//@FXML
//void walking (ActionEvent event) {
	//Scene mainScene = applicationStage.getScene();

	//VBox walkingContainer = new VBox();

	// text box with its label in a h box     
	//HBox durationW = new HBox();
	//Label walkingLabel = new Label("Distance Ran in Kilometers");
	//TextField walkingDurationTextField = new TextField();
	// adding label and text box to H box                 
	//durationW.getChildren().addAll(walkingLabel, walkingDurationTextField);
	// adding the H box to the V box                      
	//walkingContainer.getChildren().add(durationW);

	//Label caloriesBurnedW = new Label("Calories Burned: ");

	//Button calculateW = new Button("Calculate Calories Burned");

	//walkingContainer.getChildren().addAll(caloriesBurnedW, calculateW);

	//Scene walkingScene = new Scene(walkingContainer);
	//applicationStage.setScene(walkingScene);
//}
double totalCaloriesBurnedW = 0.0;
 void calculateCaloriesW (Scene walkingScene) {
	//need to add a get value for the weight
	int METW = 4;
	double bodyWeightW = 0.0;
	double totalCaloriesBurnedW = 0.0;

	String DurationW= walkingDurationTextField.getText();
	Double durationWalk = Double.parseDouble(DurationW);
	
	String BWW = weightTextField.getText();
	bodyWeightW = Double.parseDouble(BWW);
	//this invokes the class that calculates the calories burned
	//have to add soemthing the get the bodyweight 
	CountW caloriesW = new CountW(METW, durationWalk, bodyWeightW);
	//calories will be caluclated in the Countr class using the getCalorieCalc method

	totalCaloriesBurnedW += caloriesW.getCalorieCalc();
	//maybe add method in CountW class that can asses which day of the week (getDayOfWeek)
	//updatelabel
	caloriesBurnedW.setText(String.format("Calories Burned: "+totalCaloriesBurnedW));
	
	

}
 
double totalCaloriesMonday = 0.0;
void calorieDayOfWeek (Scene mainScene) {
	//https://jenkov.com/tutorials/javafx/choicebox.html
			String dayOfTheWeek = (String) weekExerciseChoiceBox.getValue();
			
			if(dayOfTheWeek == "Monday") {
				 totalCaloriesMonday += totalCaloriesBurnedW;
				 totalCaloriesMonday += totalCaloriesBurnedJ;
				 totalCaloriesMonday += totalCaloriesBurnedR;
				 
			}
			
}
	
}