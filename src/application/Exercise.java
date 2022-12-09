package application;
/**
 * This class takes the time spend doing an exercise and the user's weight to calculate
 * the calories burned during the workout.METenergy is provided internally from the authors. Has three subclasses. 
 * 
 * @author Alina, Kaleigh and Marzia
 *
 */

public abstract class Exercise {
	/**
	 * attributes data to the Exercise class using instance variables, and their functions are described above
	 */
	double weight;
	double duration;

/**
 * A constructor used to initialize the instance variables
 * @param typeOfExercise 
 * @param pounds
 */

	 Exercise(double typeOfExercise, double pounds){
		 
		 weight = pounds;
		 duration = typeOfExercise;
	 }

	 

	 
	 abstract double getCalorieCalc();
}

