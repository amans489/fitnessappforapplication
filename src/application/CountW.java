package application;
/**
 * This is a subclass of Exercise which takes the parameters of the exercise class
 * and calculates the amount of calories burned when walking based on duration.
 * @author Alina, Kaleigh, Marzia
 *
 */


public class CountW extends Exercise {
	/**
	 * instance variable for the amount of energy used when jogging, set at a constant
	 */
	private int METenergyW = 4;
	
	/**
	 * Constructor that sets the instance variables, derived from the parent class of Exercise
	 * @param energy, the MET is the metabolic equivalent of task, used to determine
	 * how much energy is used when walking
	 * @param joggingDuration, time spent walking
	 * @param pounds, weight of the user in pounds
	 */
	public CountW(double walk, double pounds) {	
		super(walk, pounds);
	}
	
	/**
	 * A getter method to return the  Metabolic Energy constant
	 * @return an integer value of the MET 
	 */
	
	public int getMETenergyW() {
		return METenergyW;
	}
	/**
	 * A method that gets the Calorie burned calculated when walking using the parent class of Exercise
	 */
	@Override
	double getCalorieCalc() {
		return METenergyW*super.weight*super.duration/(200);
	}

}
