

package application;

import java.util.ArrayList;
import java.util.Arrays;

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
	String heightvalues;
	String weightvalues;
	double [] monday = new double[3];
	double [] tuesday = new double[3];
	double [] wednesday = new double[3];
	double [] thursday = new double[3];
	double [] friday = new double[3];
	double [] saturday = new double[3];
	double [] sunday = new double[3];
	
	
	double mondaycaloriesburned = 0.0;
	double tuesdaycaloriesburned = 0.0;
	double wednesdaycaloriesburned = 0.0;
	double thursdaycaloriesburned = 0.0;
	double fridaycaloriesburned = 0.0;
	double saturdaycaloriesburned = 0.0;
	double sundaycaloriesburned = 0.0;
    @FXML
    private ChoiceBox<?> weekExerciseChoiceBox;
    
    @FXML
    private TextField runningDistanceTextField;

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
	private Label heighterror;



    @FXML
    void caloriesBurntDisplay(ActionEvent event) {
    
    	  Scene mainScene = applicationStage.getScene();
    	  
    	Scene caloriesBurntScene = new Scene(new Label("Placeholder"));
    	applicationStage.setScene(caloriesBurntScene);
    }

    @FXML
    void workoutDisplay(ActionEvent event) {
    	Scene workoutDisplayScene = new Scene(new Label("Placeholder")); 
    	applicationStage.setScene(workoutDisplayScene);
    }

    @FXML
    void userInfo(ActionEvent event){
    	Scene mainScene = applicationStage.getScene();
    	VBox containingHeightandWeight = new VBox(10);
    	
    	Scene userHeightAndWeightScene = new Scene(containingHeightandWeight,600,400);
    	
    	HBox height = new HBox();
    	
    	Label height1 = new Label("Enter your height(cm): ");
    	TextField heightTextField = new TextField();
    	height.getChildren().addAll(height1,heightTextField);
    	
    	Label weight1 = new Label("Enter your weight(kg): ");
    	TextField weightTextField = new TextField();
    	
    	HBox weight = new HBox();
    	weight.getChildren().addAll(weight1,weightTextField);
    	
    	Button done = new Button("Go back to User Info Scene");
    	
    	
    	
    	
  //RUNNING SCENE 		
    	
  		VBox runningContainer = new VBox();
  		
  		TextField weightTextfield = new TextField();
  		
  		Scene runningScene = new Scene(runningContainer);
  		
  		//runningButton.setOnAction(e-> applicationStage.setScene(runningScene));

  		// text box with its label in a h box     
  		HBox durationR = new HBox();
  		Label runningLabel = new Label("Time spent running:");
  		
  		TextField runningDurationTextField = new TextField();
  		
  		// adding label and text box to H box                 
  		durationR.getChildren().addAll(runningLabel, runningDurationTextField);
  		// adding the H box to the V box                      
  		runningContainer.getChildren().add(durationR);

  		Label caloriesBurnedR = new Label("Calories Burned: ");

  		Button calculateR = new Button ("Calculate Calories Burned");
  		Button gotoinputscene = new Button("go to input scene");
  		gotoinputscene.setOnAction(e -> userInfo(event));
  		calculateR.setOnAction(e -> calculateCaloriesR(mainScene, runningScene,runningDurationTextField, weightTextfield, caloriesBurnedR));
  		runningContainer.getChildren().addAll(caloriesBurnedR, calculateR,gotoinputscene);
  		
  //JOGGING
  		VBox joggingContainer = new VBox();
  		
  		Scene joggingScene = new Scene(joggingContainer);
  		// text box with its label in a h box     
  		HBox durationJ = new HBox();
  		Label joggingLabel = new Label("Time spent jogging: ");
  		TextField joggingDurationTextField = new TextField();
  		// adding label and text box to H box                 
  		durationJ.getChildren().addAll(joggingLabel, joggingDurationTextField);
  		// adding the H box to the V box                      
  		joggingContainer.getChildren().add(durationJ);

  		Label caloriesBurnedJ = new Label("Calories Burned: ");
  		gotoinputscene = new Button("go to input scene");
  		gotoinputscene.setOnAction(e -> userInfo(event));
  		Button calculateJ = new Button("Calculate Calories Burned");
  		calculateJ.setOnAction(e-> calculateCaloriesJ(mainScene, joggingScene, joggingDurationTextField, weightTextfield, caloriesBurnedJ));
  		joggingContainer.getChildren().addAll(caloriesBurnedJ, calculateJ,gotoinputscene);
  	
  //WALKING
  		VBox walkingContainer = new VBox();
  		
  		Scene walkingScene = new Scene(walkingContainer);

  		// text box with its label in a h box     
  		HBox durationW = new HBox();
  		Label walkingLabel = new Label("Time spent walking");
  		
  		TextField walkingDurationTextField = new TextField();
  		
  		// adding label and text box to H box                 
  		durationW.getChildren().addAll(walkingLabel, walkingDurationTextField);
  		// adding the H box to the V box                      
  		walkingContainer.getChildren().add(durationW);

  		Label caloriesBurnedW = new Label("Calories Burned: ");
  		gotoinputscene = new Button("go to input scene");
  		gotoinputscene.setOnAction(e -> userInfo(event));
  		Button calculateW = new Button("Calculate Calories Burned");
  		calculateW.setOnAction(e->calculateCaloriesW(mainScene,walkingScene, walkingDurationTextField, weightTextfield, caloriesBurnedW));
  		
  		walkingContainer.getChildren().addAll(caloriesBurnedW, calculateW,gotoinputscene);
  		
  		
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
  		heighterror = new Label("");
  	    
    	containingHeightandWeight.getChildren().addAll(height,weight,done,heighterror);
  		done.setOnAction(e->{
  			String heightvalues = heightTextField.getText();
  	    	String weightvalues = weightTextField.getText();
  	    	
  	    	
  			UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues, weightvalues);
  			boolean noerrors;
			try {
  				
  				if(heightAndWeight.check()) {
  					noerrors = true;
  					heighterror.setText("");
  					double weightvalue = Double.parseDouble(weightvalues);
  					double heightvalue = Double.parseDouble(heightvalues);
  					applicationStage.setScene(userInfoScene);
  				}  
  				
  			
  			} catch (InvalidUserException e1) {
  					noerrors = false;
  					
  					
  						heighterror.setText(e1.getMessage());
  					
  						
  					
  					System.out.println("An error was found");
  					
  				} 
  		});
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
  		
  		//TextField weightTextfield = new TextField();
  		TextField heightTextfield = new TextField();
  		Button enterUserInput = new Button("Enter your height and weight ");
  		enterUserInput.setOnAction(e->applicationStage.setScene(userHeightAndWeightScene));
  		
  		
  		
  		HBox heightBox = new HBox(7);
  		heightBox.getChildren().addAll(enterUserInput);
  		
  		
  		
  		
  		Button backToMainScene = new Button("Back");
        backToMainScene.setOnAction(e->applicationStage.setScene(mainScene));
  		container.setPadding(new Insets(0,5,0,5));
  		container.getChildren().addAll(dayOfWorkout,typeOfWorkout, walkingButton, joggingButton,
  				runningButton, heightBox,backToMainScene);
  		
  		
  		


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
 void calculateCaloriesR (Scene mainScene, Scene runningScene, TextField runningDurationTextField, TextField weightTextField, Label caloriesBurnedR) {
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

  	totalCaloriesBurnedR = caloriesR.getCalorieCalc();
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
  void calculateCaloriesJ (Scene mainscene, Scene joggingScene, TextField joggingDurationTextField, TextField weightTextfield, Label caloriesBurnedJ) {
  	//need to add a get value for the weight
  	int METJ = 7;
  	double bodyWeightJ = 0.0;
  	double totalCaloriesBurnedJ = 0.0;

  	String DurationJ= joggingDurationTextField.getText();
  	System.out.println("jog duration" + DurationJ);
  	Double durationJog = Double.parseDouble(DurationJ);
  	
  	String BWJ = weightTextfield.getText();
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
   void calculateCaloriesW(Scene walkingScene, Scene mainScene, TextField walkingDurationTextField, TextField weightTextfield, Label caloriesBurnedW) {
  	//need to add a get value for the weight
  	int METW = 4;
  	double bodyWeightW = 0.0;
  	double totalCaloriesBurnedW = 0.0;
  	
  	String DurationW= walkingDurationTextField.getText();
  	if(DurationW != null) {
  		System.out.println("textfield"+ walkingDurationTextField.getText());
  		Double durationWalk = Double.parseDouble(DurationW);
  	
  	
  	String BWW = weightTextfield.getText();
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
	
 	
  }
   
  double totalCaloriesMonday = 0.0;
  double totalCaloriesTuesday = 0.0;
  double totalCaloriesWednesday = 0.0;
  double totalCaloriesThursday = 0.0;
  double totalCaloriesFriday = 0.0;
  double totalCaloriesSaturday = 0.0;
  double totalCaloriesSunday = 0.0;
  void calorieDayOfWeek (Scene mainScene) {
  	//https://jenkov.com/tutorials/javafx/choicebox.html
  			String dayOfTheWeek = (String) weekExerciseChoiceBox.getValue();
  			
  		    
  		    	    
  		    
  			
  			if(dayOfTheWeek == "Monday") {
  				
  				 totalCaloriesMonday += totalCaloriesBurnedW;
  				 totalCaloriesMonday += totalCaloriesBurnedJ;
  				 totalCaloriesMonday += totalCaloriesBurnedR;
  				 mondaycaloriesburned = totalCaloriesMonday;
  			}
  			
  			if(dayOfTheWeek == "Tuesday") {
  				
 				 totalCaloriesTuesday += totalCaloriesBurnedW;
 				 totalCaloriesTuesday += totalCaloriesBurnedJ;
 				 totalCaloriesTuesday += totalCaloriesBurnedR;
 				 tuesdaycaloriesburned = totalCaloriesTuesday;
 				 
 			}
  			if(dayOfTheWeek == "Wednesday") {
  				
 				 totalCaloriesMonday += totalCaloriesBurnedW;
 				 totalCaloriesMonday += totalCaloriesBurnedJ;
 				 totalCaloriesMonday += totalCaloriesBurnedR;
 				 wednesdaycaloriesburned = totalCaloriesWednesday;
 				 
 			}
  			if(dayOfTheWeek == "Thursday") {
  				
 				 totalCaloriesThursday += totalCaloriesBurnedW;
 				 totalCaloriesThursday += totalCaloriesBurnedJ;
 				 totalCaloriesThursday += totalCaloriesBurnedR;
 				 thursdaycaloriesburned = totalCaloriesThursday;
 			}
  			if(dayOfTheWeek == "Friday") {
  				
 				 totalCaloriesFriday += totalCaloriesBurnedW;
 				 totalCaloriesFriday += totalCaloriesBurnedJ;
 				 totalCaloriesFriday += totalCaloriesBurnedR;
 				 fridaycaloriesburned = totalCaloriesFriday;
 				 
 			}if(dayOfTheWeek == "Saturday") {
  				
 				 totalCaloriesSaturday += totalCaloriesBurnedW;
 				 totalCaloriesSaturday += totalCaloriesBurnedJ;
 				 totalCaloriesSaturday += totalCaloriesBurnedR;
 				 saturdaycaloriesburned = totalCaloriesSaturday;
 				 
 			}if(dayOfTheWeek == "Sunday") {
  				
 				 totalCaloriesSunday += totalCaloriesBurnedW;
 				 totalCaloriesSunday += totalCaloriesBurnedJ;
 				 totalCaloriesSunday += totalCaloriesBurnedR;
 				 sundaycaloriesburned = totalCaloriesSunday;
 			}
  			
  }
  	
  }
