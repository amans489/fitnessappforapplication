package application;
/**
 *This is an error handling class for invalid height and weight values
 *Will display an error message if the input is invalid
 * @author Alina, Kaleigh, Marzia
 *
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class UserInputErrorHandling {
	/**
	 * instance variable for the weight and height input by the user
	 */
	String height;
	String weight; 
	/**
	 * A contructor that sets the instance values for height and weight
	 * @param height input by the user in inches
	 * @param weight input by the user in pounds
	 */

	public UserInputErrorHandling(String height,String weight) {
		System.out.println(height + weight);
		this.height = height;
		this.weight = weight;

	}	
	/**
	 * A method that checks whether both height and weight are null
	 * if they are both null return false for further handling, or too many decimal points
	 * @param heightAndWeight
	 * @return boolean state of whether height and weight are null
	 */

	public boolean check2(String heightAndWeight)
	{
		boolean b = true;
		if (heightAndWeight == null || heightAndWeight == "")
			b = false;
		return b;
	}
	/**
	 * The method that checks for proper syntax of the input made by the user
	 * It handles errors such as alphabetical characters, values not possible for human height and weight,
	 * units, and checks for whether the textfield is null
	 * @return a boolean state of whether theres an exception or not
	 * @throws InvalidUserException
	 */

	public boolean check () throws InvalidUserException
	{
		boolean b = true;
		int period_count_for_height = 0;
		int period_count_for_weight = 0;

		for (char g: height.toCharArray()) {

			if (!Character.isDigit(g) && g != '.') {
				b = false;
				throw new InvalidUserException("Don't include the character: " + g + "." + " " + 
						" Height should be a number and should not have multiple '.'");


			}if (g == '.') {
				period_count_for_weight += 1;

			}

		} 
		if (period_count_for_height > 1) {
			b = false;
			throw new InvalidUserException("Don't include the multiple periods: " + "." + "." + " " +
					"Height should be a number. ");
		}	if (period_count_for_weight > 1) {
			b = false;
			throw new InvalidUserException("Don't include the multiple periods: " + "." + "." + " " +
					"Weight should be a number. ");
		}	

		if (check2(height)) {
			double height = Double.parseDouble(this.height);
			if (height < 0 || height > 213.36 ) {
				b = false;
				throw new InvalidUserException("Height should be between 0 & 213.36" + "." + " " + 
						"Invalid Height: " + this.height);			
			} } else {
				throw new InvalidUserException("Height textfield is null");
			}


		for (char e: weight.toCharArray()) {
			if (!Character.isDigit(e) && e != '.') {
				b = false;
				throw new InvalidUserException("Don't include the character: " + e + "." + " " + 
						" Weight should be a number and should not have multiple '.'");

			}
			if (e == '.') {
				period_count_for_weight += 1;

			}
		}

		if (check2(weight)) {
			double weight = Double.parseDouble(this.weight);

			if (weight < 0 || weight > 727 ) {
				b = false;
				throw new InvalidUserException("Weight should be between 0 & 727" + "." + " " + 
						"Invalid Weight: " + this.weight);	}
		}
		else {
			throw new InvalidUserException("Weight textfield is null");
		}

		return b;
	}



}

