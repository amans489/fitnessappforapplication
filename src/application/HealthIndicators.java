package application;
/**
 * This class takes the height and weight input from the user to calculate 
 * their BMI (body mass index)
 * @author Alina, Kaleigh and Marzia
 *
 */

public class HealthIndicators {
	/**
	 * attributes data to the HealthIdicators class using instance variables
	 */
	private double heightvalue;
	private double weightvalue;
	private double bmi;

	/**
	 * A constructor used to convert height and weight value entered by the user to a double
	 * @param height input from user
	 * @param weight input from user
	 */
	public HealthIndicators(String height,String weight) {
		heightvalue = Double.parseDouble(height);
		weightvalue = Double.parseDouble(weight);
	}
	/**
	 * Setter method that sets the instance variable of height
	 * @return the instance of height
	 */
	public double setHeight() {
		return heightvalue;
	}

	/**
	 * Setter method that sets the instance variable of weight 
	 * @return the instance of weight
	 */
	public double setWeight() {
		return weightvalue;
	}
	/**
	 * A method that calculates the BMI of an individual based on the height and weight value 
	 * input from the user
	 * @return the calculated BMI for a given height and weight
	 */

	public double getBMI() {
		return bmi = weightvalue / ((heightvalue) * (heightvalue));
	}
}

	