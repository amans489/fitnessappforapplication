package application;

/**
 * This is a subclass of Exercise which takes the parameters of the exercise class
 * and calculates the amount of calories burned when running based on duration.
 * @author Alina, Kaleigh, Marzia
 *
 */
public class CountR extends Exercise {

	/**
	 * instance variable for the amount of energy used when running, set at a constant
	 */
	private int METenergyJ = 4;

	/**
	 * Constructor that sets the instance variables, derived from the parent class of Exercise
	 * @param energy, the MET is the metabolic equivalent of task, used to determine
	 * how much energy is used when running
	 * @param runningDuration, time spent running
	 * @param pounds, weight of the user in pounds
	 */
	CountR(int energy, double runningDuration, double pounds) {
		super(energy, runningDuration, pounds);

	}
}