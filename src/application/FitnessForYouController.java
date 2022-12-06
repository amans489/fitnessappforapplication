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
	double bmi;
	String height;
	String weight;
	double heightValue;
	double weightValue;
	double timing;
	double totalCaloriesBurnedW = 0.0;
	double bmiResult;
	double heightOfUser;
	double weightOfUser;
	TimeInputErrorHandling time;

	@FXML
	private Label weightLabel;

	@FXML
	private Label walkingErrorLabel;

	@FXML
	private Label joggingErrorLabel;

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





	@FXML
	void userInfo(ActionEvent event) {

		String heightValues = heightTextField.getText();
		String weightValues = weightTextField.getText();


		UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightValues, weightValues);
		boolean noErrors;
		try {

			if(heightAndWeight.check()) {
				noErrors = true;
				heightErrorLabel.setText("");
				weightValue = Double.parseDouble(weightValues);
				heightValue = Double.parseDouble(heightValues);

				determineTypeOfExercise(event);
			}  


		} catch (InvalidUserException e1) {
			noErrors = false;
			heightErrorLabel.setText(e1.getMessage());

			System.out.println("An error was found");



		} 
	};


	//  		@FXML
	//  		final double errorchecking() {
	//  			String heightvalues = heightTextField.getText();
	//  			String weightvalues = weightTextField.getText();
	//  			UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues, weightvalues);
	//  			boolean noerrors;
	//			try {
	//  				
	//  				if(heightAndWeight.check()) {
	//  					noerrors = true;
	//  					heightErrorLabel.setText("");
	//  					heightofuser = heightAndWeight.heightofuser;
	//  					weightofuser = heightAndWeight.weightofuser;
	//  				
	//  				}  
	//  				
	//  			
	//  			} catch (InvalidUserException e1) {
	//  					noerrors = false;
	//  					heightErrorLabel.setText(e1.getMessage());
	//  					
	//  					System.out.println("An error was found");
	//  						
	//  	
	//  					
	//  				}
	//			
	//  		};
	//  			



	@FXML
	void displayBMIresult(double bmiresulttodisplay) {

		bmiLabel.setText("Your bmi is: " +bmiresulttodisplay );
	}

	@FXML
	void calculateBMI(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		String heightValues = heightTextField.getText();
		String weightValues = weightTextField.getText();


		UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightValues, weightValues);
		boolean noErrors;
		try {

			if(heightAndWeight.check()) {
				noErrors = true;

				bmiResult = bmicalculation(weightValue, heightValue);	
				HealthIndicators health = new HealthIndicators(heightTextField.getText(),weightTextField.getText());
				bmiResult = health.getBMI();
				displayBMIresult(bmiResult);
			}  
		} catch (InvalidUserException e1) {
			noErrors = false;
			bmiLabel.setText(e1.getMessage());

			System.out.println("An error was found");

		} 
	};









	private double bmicalculation(double weightvalue2, double heightvalue2) {
		return (weightvalue2)/((heightvalue2)*(heightvalue2));

	}


	@FXML
	void goToMainScene(ActionEvent event) {

		Scene mainScene = applicationStage.getScene();
		//	applicationStage.setScene(mainScene);
	}
	
	
	@FXML
	void determineTypeOfExercise (ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		VBox container = new VBox(10);

		//Scene userInfoScene = new Scene(new Label(("Enter Information"),(container)));
		Scene userInfoScene = new Scene(container,600,400);
		
		applicationStage.setScene(userInfoScene);
		applicationStage.setTitle("Determine type of exercise");
		// ChoiceBox weekExerciseChoiceBox = new ChoiceBox();
		//weekExerciseChoiceBox.setOnAction()
		Button walkingButton = new Button("Walking");
		walkingButton.setOnAction(e-> walking());


		//walkingButton.setOnAction(new CountW);

		Button joggingButton = new Button("Jogging");
		walkingButton.setOnAction(e-> jogging());

		//  		joggingButton.setOnAction(new CountJ);
		//  		joggingButton.setOnAction(e-> applicationStage.setScene(joggingScene));
		Button runningButton = new Button("Running");
		//runningButton.setOnAction(new CountR)
		//		runningButton.setOnAction(e-> applicationStage.setScene(runningScene));
		Button backToMainScene = new Button("Back");

		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));

		container.setPadding(new Insets(0,5,0,5));
		container.getChildren().addAll( walkingButton, joggingButton,runningButton,backToMainScene);


	}




	@FXML
	void walking() {


		VBox walkingContainer = new VBox();
		Scene mainScene = applicationStage.getScene();

		Scene walkingScene = new Scene(walkingContainer,600,400);
		applicationStage.setScene(walkingScene);
		applicationStage.setTitle("calories burned for walking");
		// text box with its label in a h box  
		System.out.println("sdkgjdfg");

		HBox durationW = new HBox();
		Label walkingLabel = new Label("Time spent walking");

		TextField walkingDurationTextField = new TextField();

		//  		// adding label and text box to H box                 
		durationW.getChildren().addAll(walkingLabel, walkingDurationTextField);
		//  		// adding the H box to the V box                      


		Label caloriesBurnedW = new Label("Calories Burned: ");

		Button calculateW = new Button("Calculate Calories Burned");
		Button backToMainScene = new Button("Back");
		Label walkingErrorLabel = new Label("Time error");
		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
		walkingErrorLabel.setText("gfdh");
		walkingContainer.getChildren().addAll(durationW,walkingLabel,walkingDurationTextField,caloriesBurnedW,calculateW,backToMainScene,walkingErrorLabel);
		boolean noErrors;
		calculateW.setOnAction(e->calculateCaloriesW(walkingDurationTextField, weightValue, caloriesBurnedW,walkingErrorLabel));	
	}

	@FXML
	void jogging() {


		VBox joggingContainer = new VBox();
		Scene mainScene = applicationStage.getScene();

		Scene joggingScene = new Scene(joggingContainer,600,400);
		applicationStage.setScene(joggingScene);
		applicationStage.setTitle("calories burned for jogging");
		// text box with its label in a h box  
		System.out.println("sdkgjdfg");

		HBox durationJ = new HBox();
		Label joggingLabel = new Label("Time spent jogging");

		TextField joggingDurationTextField = new TextField();

		//  		// adding label and text box to H box                 
		durationJ.getChildren().addAll(joggingLabel, joggingDurationTextField);
		//  		// adding the H box to the V box                      


		Label caloriesBurnedJ = new Label("Calories Burned: ");

		Button calculateJ = new Button("Calculate Calories Burned");
		Button backToMainScene = new Button("Back");
		Label joggingErrorLabel = new Label("Time error");
		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
		joggingErrorLabel.setText("gfdh");
		joggingContainer.getChildren().addAll(durationJ,joggingLabel,joggingDurationTextField,caloriesBurnedJ,calculateJ,backToMainScene,joggingErrorLabel);
		boolean noerrors;
		calculateJ.setOnAction(e->calculateCaloriesW(joggingDurationTextField, weightValue, caloriesBurnedJ,joggingErrorLabel));	
	}



	@FXML
	void running() {


		VBox joggingContainer = new VBox();
		Scene mainScene = applicationStage.getScene();

		Scene joggingScene = new Scene(joggingContainer,600,400);
		applicationStage.setScene(joggingScene);
		applicationStage.setTitle("calories burned for jogging");
		// text box with its label in a h box  
		System.out.println("sdkgjdfg");

		HBox durationJ = new HBox();
		Label joggingLabel = new Label("Time spent jogging");

		TextField joggingDurationTextField = new TextField();

		//  		// adding label and text box to H box                 
		durationJ.getChildren().addAll(joggingLabel, joggingDurationTextField);
		//  		// adding the H box to the V box                      


		Label caloriesBurnedJ = new Label("Calories Burned: ");

		Button calculateJ = new Button("Calculate Calories Burned");
		Button backToMainScene = new Button("Back");
		Label joggingErrorLabel = new Label("Time error");
		backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
		joggingErrorLabel.setText("gfdh");
		joggingContainer.getChildren().addAll(durationJ,joggingLabel,joggingDurationTextField,caloriesBurnedJ,calculateJ,backToMainScene,joggingErrorLabel);
		boolean noerrors;
		calculateJ.setOnAction(e->calculateCaloriesW(joggingDurationTextField, weightValue, caloriesBurnedJ,joggingErrorLabel));	
	}









	void calculateCaloriesW(TextField walkingDurationTextField, double weightvalue, Label caloriesBurnedW,Label walkingErrorLabel) {
		//need to add a get value for the weight
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
				bodyWeightW = weightvalue;
				//this invokes the class that calculates the calories burned
				//have to add soemthing the get the bodyweight 
				System.out.println("fjkdfgdfg" + weightvalue);

				CountW caloriesW = new CountW(METW, timing, bodyWeightW);
				//calories will be caluclated in the Countr class using the getCalorieCalc method

				totalCaloriesBurnedW += caloriesW.getCalorieCalc();

				//maybe add method in CountW class that can asses which day of the week (getDayOfWeek)
				//updatelabel
				caloriesBurnedW.setText(String.format("Calories Burned: "+totalCaloriesBurnedW));

			}





		} catch (InvalidUserException e1) {
			noerrors = false;
			walkingErrorLabel.setText(e1.getMessage());

			System.out.println("An error was found");



		} 
	}







}


