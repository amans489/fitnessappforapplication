package application;
/**This is the controller class for the FitnessForYouController
 * This class prompts the user for height and weight, these values are used to calculate BMI directly on the main scene
 * The user has the option to choose what day of the week they are working out on
 * They can then click a button that will bring them to another scene that 
 * lets them choose what type of exercise they completed
 * It creates three scenes, and calculates the amount of calories burned based on the time 
 * they spent working out and the type of exercise they completed
 * @author Marzia, Alina and Kaleigh
 */

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
	/**
	 * Data attributed to this class
	 */
	Stage applicationStage;
	double bmi;
	String height;
	String weight;
	//cannot change the variable name for the next two due to conflict
	double heightvalue;
	double weightvalue;
	double timing;
	double totalCaloriesBurnedW = 0.0;
	double bmiResult;
	double heightofuservalue;
	double weightofuservalue;
	String heightValues;
	String weightValues;
	boolean noerrors;
	TimeInputErrorHandling time;

	@FXML
	private Label weightLabel;

	@FXML
	private Label walkingErrorLabel;

	@FXML
	private ChoiceBox<?> weekExerciseChoiceBox;

	@FXML
	private TextField heightTextField;

	@FXML
	private Label heightLabel;

	@FXML
	private TextField weightTextField;

	@FXML 
	private Label heightErrorLabel;

	@FXML
	private Label bmiLabel;


	/**Takes the height and weight info from user input
	 * ensures the user has input a valid number, has error handling
	 */

	@FXML
	void userInfo(ActionEvent event) {

		String heightvalues = heightTextField.getText();
		String weightvalues = weightTextField.getText();


		UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues, weightvalues);
		boolean noerrors;


		if(heightAndWeight.check2(heightvalues) && heightAndWeight.check2(weightvalues))
		{
			noerrors = true;
			heightErrorLabel.setText("");
			if (heightvalues != null && weightvalues != null) {
				weightvalue = Double.parseDouble(weightvalues);
				heightvalue = Double.parseDouble(heightvalues);

				determinetypeofexercise(event);} 
			else {
				heightErrorLabel.setText("Height and Weight shouldn't be null");
			}
		}
	}

	/**
	 * displays the BMI based user info on the main scene
	 * @param bmiResultToDisplay
	 */


	@FXML
	void displayBMIresult(double bmiResultToDisplay) {

		bmiLabel.setText("Your BMI is: " +String.format("%.2f", bmiResultToDisplay ));
	}

	/**
	 * calculates the BMI of the user based on the height and weight input with error handling
	 * @param event
	 */

	@FXML
	void calculateBMI(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		String heightvalues = heightTextField.getText();
		String weightvalues = weightTextField.getText();


		UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues, weightvalues);
		boolean noerrors;
		try {

			if(heightAndWeight.check()) {
				noerrors = true;

				bmiResult = bmicalculation(weightvalue, heightvalue);	
				HealthIndicators health = new HealthIndicators(heightTextField.getText(),weightTextField.getText());
				bmiResult = health.getBMI();
				displayBMIresult(bmiResult);

			}  


		} catch (InvalidUserException e1) {
			noerrors = false;
			bmiLabel.setText(e1.getMessage());

			System.out.println("An error was found");


		} 
	};




	/**
	 * Actual calculation for BMI based on height and weight
	 * @param weightvalue2 input entered by user
	 * @param heightvalue2 input entered by user
	 * @return the BMI number, used by calculateBMI()
	 */



	private double bmicalculation(double weightvalue2, double heightvalue2) {
		return (weightvalue2)/((heightvalue2)*(heightvalue2));

	}
	/**
	 * An instance of main scene from the determine type of exercise scene
	 * @param event
	 */

	@FXML
	void goToMainScene(ActionEvent event) {

		Scene mainScene = applicationStage.getScene();
	}

	/**
	 * A method that creates a scene that prompts the user to pick between three exercise options
	 * Based on the button clicked it will go to a different scene
	 * It has a back button to go back to the main scene
	 * @param event button clicked to pick the type of exercise completed from main scene
	 */
	@FXML
	void determinetypeofexercise (ActionEvent event) {

		String dayOfWeek = (String) weekExerciseChoiceBox.getValue();
		Label dayOfWorkout = new Label("Day of the Week: " + dayOfWeek);
		Label typeOfWorkout = new Label("Choose a Type of Workout: ");
		Scene mainScene = applicationStage.getScene();
		VBox container = new VBox(10);

		Scene userInfoScene = new Scene(container,600,400);



		applicationStage.setScene(userInfoScene);
		applicationStage.setTitle("Exercise Options");

		Button walkingButton = new Button("Walking");
		walkingButton.setOnAction(e-> walking());


		Button joggingButton = new Button("Jogging");
		joggingButton.setOnAction(e-> jogging());


		Button runningButton = new Button("Running");
		runningButton.setOnAction(e-> running());

		Button backToMainScene = new Button("Back");

		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));

		container.setPadding(new Insets(0,5,0,5));
		container.getChildren().addAll(dayOfWorkout, typeOfWorkout,walkingButton, joggingButton,runningButton,backToMainScene);


	}


	/**
	 * A method that creates the walking scene from the button clicked in the user input scene
	 * It then prompts the user for the amount of time walked
	 * Displays the amount of calories burned 
	 * Has a back button to go back to the input scene
	 */

	@FXML
	void walking() {


		VBox walkingContainer = new VBox(7);
		walkingContainer.setPadding(new Insets(0,5,0,5));
		Scene mainScene = applicationStage.getScene();

		Scene walkingScene = new Scene(walkingContainer,600,400);
		applicationStage.setScene(walkingScene);
		applicationStage.setTitle("calories burned for walking");

		HBox durationW = new HBox();

		Label walkingLabel = new Label("Time spent walking");

		TextField walkingDurationTextField = new TextField();
		walkingDurationTextField.setMaxWidth(150);
		durationW.getChildren().addAll(walkingLabel, walkingDurationTextField);  


		Label caloriesBurnedW = new Label("Calories Burned: ");

		Button calculateW = new Button("Calculate Calories Burned");
		Button backToMainScene = new Button("Back");
		Label walkingErrorLabel = new Label("Time error");
		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
		walkingErrorLabel.setText("");
		walkingContainer.getChildren().addAll(durationW,walkingLabel,walkingDurationTextField,caloriesBurnedW,calculateW,backToMainScene,walkingErrorLabel);
		boolean noerrors;
		calculateW.setOnAction(e->calculateCaloriesW(walkingDurationTextField, weightvalue, caloriesBurnedW,walkingErrorLabel));	
	}



	/**
	 * A method that creates the jogging scene from the button clicked in the user input scene
	 * It then prompts the user for the amount of time jogged
	 * Displays the amount of calories burned 
	 * Has a back button to go back to the input scene
	 */

	@FXML
	void jogging() {


		VBox joggingContainer = new VBox(7);
		joggingContainer.setPadding(new Insets(0,5,0,5));
		Scene mainScene = applicationStage.getScene();

		Scene joggingScene = new Scene(joggingContainer,600,400);
		applicationStage.setScene(joggingScene);
		applicationStage.setTitle("Calories burned for jogging");
		HBox durationJ = new HBox();

		Label joggingLabel = new Label("Time spent jogging");

		TextField joggingDurationTextField = new TextField();
		joggingDurationTextField.setMaxWidth(150);
		durationJ.getChildren().addAll(joggingLabel, joggingDurationTextField);


		Label caloriesBurnedJ = new Label("Calories Burned: ");

		Button calculateJ = new Button("Calculate Calories Burned");
		Button backToMainScene = new Button("Back");
		Label joggingErrorLabel = new Label("Time error");
		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
		joggingErrorLabel.setText("");
		joggingContainer.getChildren().addAll(durationJ,joggingLabel,joggingDurationTextField,caloriesBurnedJ,calculateJ,backToMainScene,joggingErrorLabel);
		boolean noerrors;
		calculateJ.setOnAction(e->calculateCaloriesJ(joggingDurationTextField, weightvalue, caloriesBurnedJ,joggingErrorLabel));	
	}



	/**
	 * A method that creates the running scene from the button clicked in the user input scene
	 * It then prompts the user for the amount of time they ran for
	 * Displays the amount of calories burned 
	 * Has a back button to go back to the input scene
	 */

	@FXML
	void running() {


		VBox runningContainer = new VBox(7);
		runningContainer.setPadding(new Insets(0,5,0,5));
		Scene mainScene = applicationStage.getScene();

		Scene runningScene = new Scene(runningContainer,600,400);
		applicationStage.setScene(runningScene);
		applicationStage.setTitle("Calories burned for running");

		HBox durationR = new HBox();		
		Label runningLabel = new Label("Time spent running");

		TextField runningDurationTextField = new TextField();
		runningDurationTextField.setMaxWidth(150);
		durationR.getChildren().addAll(runningLabel, runningDurationTextField);

		Label caloriesBurnedR = new Label("Calories Burned: ");

		Button calculateR = new Button("Calculate Calories Burned");
		Button backToMainScene = new Button("Back");
		Label runningErrorLabel = new Label("Time error");
		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
		runningErrorLabel.setText("");
		runningContainer.getChildren().addAll(durationR,runningLabel,runningDurationTextField,caloriesBurnedR,calculateR,backToMainScene,runningErrorLabel);
		boolean noerrors;
		calculateR.setOnAction(e->calculateCaloriesR(runningDurationTextField, weightvalue, caloriesBurnedR,runningErrorLabel));	
	}


	/**
	 * Calculates the calories burned based on the weight and the amount of time spent walking
	 * has error handling	
	 * @param walkingDurationTextField time spent walking
	 * @param weightvalue of the user
	 * @param caloriesBurnedW label to display the amount of calories burned
	 * @param walkingErrorLabel if the user inputs an invalid time
	 */



	void calculateCaloriesW(TextField walkingDurationTextField, double weightValue, Label caloriesBurnedW,Label walkingErrorLabel) {
		int METW = 4;
		double bodyWeightW = 0.0;
		double totalCaloriesBurnedW = 0.0;

		String DurationW= walkingDurationTextField.getText();



		TimeInputErrorHandling duration = new TimeInputErrorHandling(DurationW);
		boolean noerrors;
		try {

			if(duration.check() && walkingDurationTextField.getText() != null ) {
				noerrors = true;
				walkingErrorLabel.setText("");
				timing = Double.parseDouble(DurationW);
				bodyWeightW = weightValue;
				CountW caloriesW = new CountW(timing, bodyWeightW);
				totalCaloriesBurnedW += caloriesW.getCalorieCalc();
				caloriesBurnedW.setText(String.format("Calories Burned: "+totalCaloriesBurnedW));

			}


		} catch (InvalidUserException e1) {
			noerrors = false;
			walkingErrorLabel.setText(e1.getMessage());

			System.out.println("An error was found");



		} 
	}
	/**
	 * Calculates the calories burned based on the weight and the amount of time spent jogging
	 * has error handling	
	 * @param joggingDurationTextField time spent jogging
	 * @param weightvalue of the user
	 * @param caloriesBurnedJ label to display the amount of calories burned
	 * @param walkingErrorLabel if the user inputs an invalid time
	 */


	void calculateCaloriesJ(TextField joggingDurationTextField, double weightvalue, Label caloriesBurnedJ,Label joggingErrorLabel) {
		int METW = 4;
		double bodyWeightJ = 0.0;
		double totalCaloriesBurnedJ = 0.0;

		String DurationJ= joggingDurationTextField.getText();

		TimeInputErrorHandling duration = new TimeInputErrorHandling(DurationJ);
		boolean noerrors;
		try {

			if(duration.check() && joggingDurationTextField.getText() != null ) {
				noerrors = true;
				joggingErrorLabel.setText("");
				timing = Double.parseDouble(DurationJ);
				bodyWeightJ = weightvalue;
				CountJ caloriesJ = new CountJ(timing, bodyWeightJ);
				totalCaloriesBurnedJ += caloriesJ.getCalorieCalc();
				caloriesBurnedJ.setText(String.format("Calories Burned: "+totalCaloriesBurnedJ));

			}


		} catch (InvalidUserException e1) {
			noerrors = false;
			joggingErrorLabel.setText(e1.getMessage());

			System.out.println("An error was found");					


		} 
	}

	/**
	 * Calculates the calories burned based on the weight and the amount of time spent running
	 * has error handling	
	 * @param runningDurationTextField time spent running
	 * @param weightvalue of the user
	 * @param caloriesBurnedR label to display the amount of calories burned
	 * @param runningErrorLabel if the user inputs an invalid time
	 */

	void calculateCaloriesR(TextField runningDurationTextField, double weightvalue, Label caloriesBurnedR,Label runningErrorLabel) {
		int METW = 4;
		double bodyWeightR = 0.0;
		double totalCaloriesBurnedR = 0.0;		
		String DurationR= runningDurationTextField.getText();

		TimeInputErrorHandling duration = new TimeInputErrorHandling(DurationR);
		boolean noerrors;
		try {


			if(duration.check() && runningDurationTextField.getText() != null ) {
				noerrors = true;
				runningErrorLabel.setText("");
				timing = Double.parseDouble(DurationR);
				bodyWeightR = weightvalue;
				CountR caloriesR = new CountR(timing, bodyWeightR);
				totalCaloriesBurnedR += caloriesR.getCalorieCalc();
				caloriesBurnedR.setText(String.format("Calories Burned: "+totalCaloriesBurnedR));

			}


		} catch (InvalidUserException e1) {
			noerrors = false;
			runningErrorLabel.setText(e1.getMessage());

			System.out.println("An error was found");					


		} 
	}


}
 
 
