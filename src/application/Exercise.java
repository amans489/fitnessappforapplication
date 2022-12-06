package application;

/**
 * This class takes the time spend doing an exercise and the user's weight to calculate
 * the calories burned during the workout.METenergy is provided internally from the authors. Has three subclasses. 
 * 
 * @author Alina, Kaleigh and Marzia
 *
 */
public class Exercise {
	
	/**
	 * attributes data to the Exercise class using instance variables, and their functions are described above
	 */
	
	double weight;
	int METenergy;
	double duration;
	
	/**
	 * A constructor used to initialize the instance variables
	 * @param energy, the MET is the metabolic equivalent of task, used to determine
	 * how much energy is used for each exercise
	 * @param durationOfExercise, time spent exercising
	 * @param pounds, weight of the user in pounds
	 */

	 Exercise(int energy, double durationOfExercise, double pounds){
		 METenergy = energy;
		 weight = pounds;
		 duration = durationOfExercise;
	 }

	 
	// public double calorieCalc (int MET, double distanceRan, double bodyW) {

	// double caloriesBurned = (MET*distanceRan*bodyW)/200;
	 //return caloriesBurned;
	 
	 /**
	  * a method that takes the information of the instance variables and calculates total calories burned
	  * @return the number of calories burned
	  */
	 
	 double getCalorieCalc() {
	return (METenergy*weight*duration)/200;
	 }
}

