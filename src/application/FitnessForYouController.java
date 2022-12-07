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
	double heightvalue;
	double weightvalue;
	double timing;
	double totalCaloriesBurnedW = 0.0;
	double bmiresult;
	double heightofuservalue;
	double weightofuservalue;
	String heightvalues;
	String weightvalues;
	boolean noerrors;
	TimeInputErrorHandling time;
	double caloriesBurnedforWalking;
	boolean userInfoChecking;
	UserInputErrorHandling heightAndWeight;
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
    
    
 	
   /* @FXML
	boolean errorchecking(String heightvalues2, String weightvalues2) {
	
		//UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues2, weightvalues2);
		
	//try {
			
			if(heightAndWeight.check()) {
				noerrors = true;
				heightErrorLabel.setText("");
				heightofuservalue = Double.parseDouble(heightAndWeight.height);
				weightofuservalue = Double.parseDouble(heightAndWeight.weight);
			
			}  
		
		//} catch (InvalidUserException e1) {
				noerrors = false;
				heightErrorLabel.setText(e1.getMessage());
				
			
			//}
	return noerrors;
	
	}*/
   
    @FXML
    String height() {
		heightvalues = heightTextField.getText();
		return heightvalues;
    	
    }
    
    @FXML
    String weight() {
    	weightvalues = weightTextField.getText();
    	return weightvalues;
    }
    
//    @FXML
//    public userInfoValidation(heightvalues,weightvalues) throws InvalidUserExceptions {
    	
    	

   @FXML
    void userInfo(ActionEvent event) {
	    	heightErrorLabel.setText("");
  			String heightvalues = height();
  	    	String weightvalues = weight();
  	    	userInfoValidation(heightvalues,weightvalues);
   }
//  	    	
//  	    	
//  			UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues, weightvalues);
//  			boolean noerrors;
////			
//  				
//  				
//  						
////  					noerrors = true;
//	   				try {
//	   					try {
//							if(heightAndWeight.check2(heightvalues) && heightAndWeight.check2(weightvalues) && heightAndWeight.check()) {
//							
//	   						noerrors = true;
//							heightErrorLabel.setText("");
//							
//							weightvalue = Double.parseDouble(weightvalues);
//							heightvalue = Double.parseDouble(heightvalues);
//
//							determinetypeofexercise(event);} 
//							else {
//								heightErrorLabel.setText("Height and Weight shouldn't be null");
//							}
//		 
//							
//		
//						} catch (NumberFormatException e) {
//							// 
//							
//						} catch (InvalidUserException e) {
//							
//								heightErrorLabel.setText(e.getMessage());
//								System.out.println("Hello");
//						} finally {
//							
//						} 
//						}
//	   				finally {
//	   					
//	   				}
//	   				}  
//	   					
	   				
	   				
	    
  		
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
  		

	
  		private void userInfoValidation(String heightvalues2, String weightvalues2) {
  			UserInputErrorHandling heightAndWeight = new UserInputErrorHandling(heightvalues,weightvalues);
  	    	try {
  				if(heightAndWeight.check2(heightvalues) && heightAndWeight.check2(weightvalues) && heightAndWeight.check()) {
  					noerrors = true; 
  					heightErrorLabel.setText("");
  					determinetypeofexercise(null);
  				} else {
  					noerrors = false;
  				}
  			} catch (InvalidUserException e) {
  				heightErrorLabel.setText(e.getMessage());
  			}
  	    	
  	    }
	


		@FXML
  		void displayBMIresult(double bmiresulttodisplay) {
  
  			bmiLabel.setText("Your bmi is: " +bmiresulttodisplay );
  		}
  	
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
  				
  					bmiresult = bmicalculation(weightvalue, heightvalue);	
  					HealthIndicators health = new HealthIndicators(heightTextField.getText(),weightTextField.getText());
  					bmiresult = health.getBMI();
  					displayBMIresult(bmiresult);
  					System.out.println("dskjgfd");
  					
  					
  				}  
  				
  			
  			} catch (InvalidUserException e1) {
  					noerrors = false;
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
 void determinetypeofexercise (ActionEvent event) {
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
  		boolean noerrors;
  		calculateW.setOnAction(e->calculateCaloriesW(walkingDurationTextField, weightvalue, caloriesBurnedW,walkingErrorLabel));	
 }
			
	    	
	    	
  			
		

    	
        // assuming that project is worth 50% towards the course grade
    	
// @FXML
//	final double errorcheckingfortime(walkingDurationTextField.getText(),walkingErrorLabel) {
//		String timevalues = walkingDurationTextField.getText();
//		
//		TimeInputErrorHandling time = new TimeInputErrorHandling(timevalues);
//		boolean noerrors;
//	try {
//			
//			if(time.check()) {
//				noerrors = true;
//				walkinErrorLabel.setText("");
//				timeduration = Double.parseDouble(time.timevalues);
//				
//			
//			}  
//		
//		} catch (InvalidUserException e1) {
//				noerrors = false;
//				heightErrorLabel.setText(e1.getMessage());
//				
//			
//			}
//	return time;
//	
//	}
//
// 
//  		


   

	

  		
 private double caloriesBurntCalculation(CountW caloriesWalking) {
		return (totalCaloriesBurnedW += caloriesWalking.getCalorieCalc());
		
	}  		
  		

//boolean timeVerification() {
//	TimeInputErrorHandling duration = new TimeInputErrorHandling(DurationW);
//	boolean noerrors;
//	try { 
//		if (duration,
//	}
//}

 
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
				
				CountW caloriesW = new CountW(timing, bodyWeightW);
				
				//calories will be caluclated in the Countr class using the getCalorieCalc method
				caloriesBurnedforWalking = caloriesBurntCalculation(caloriesW);
				//totalCaloriesBurnedW += caloriesW.getCalorieCalc();
				
				//maybe add method in CountW class that can asses which day of the week (getDayOfWeek)
				//updatelabel
				displayCaloriesResult(caloriesBurnedforWalking,caloriesBurnedW);
//				caloriesBurnedW.setText(String.format("Calories Burned: "+totalCaloriesBurnedW));

				}
				
				
			  
			
		
		} catch (InvalidUserException e1) {
				noerrors = false;
				walkingErrorLabel.setText(e1.getMessage());
				
				System.out.println("An error was found");
					

				
			} 
	}

private void displayCaloriesResult(double caloriesBurnedforWalking2, Label caloriesBurnedW) {
	caloriesBurnedW.setText(String.format("Calories Burned: "+caloriesBurnedforWalking2));
	
}

		

	
	
	
	
}
 
 
