package application;

/**
 * This is a subclass of Exercise which takes the parameters of the exercise class
 * and calculates the amount of calories burned when jogging based on duration.
 * @author Alina, Kaleigh, Marzia
 *
 */
public class CountW extends Exercise {

	/**
	 * instance variable for the amount of energy used when walking, set at a constant
	 */
	private int METenergyJ = 4;

	/**
	 * Constructor that sets the instance variables, derived from the parent class of Exercise
	 * @param energy, the MET is the metabolic equivalent of task, used to determine
	 * how much energy is used  when walking
	 * @param walkingDuration, time spent walking
	 * @param pounds, weight of the user in pounds
	 */
	CountW(int energy, double walkingDuration, double pounds) {
		super(energy, walkingDuration, pounds);

	}
}
