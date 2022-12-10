package application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 *This is an error handling class for the time taken to complete each exercise
 *It error handles empty textfields, and impossible time (more than 24 hours)
 * @author Alina, Kaleigh, Marzia
 *
 */
public class TimeInputErrorHandling {
	String time;

	/**
	 * A constructor that sets an instance of time
	 * @param timing
	 */
	public TimeInputErrorHandling(String timing) {		
		this.time = timing;
	}	

	/**
	 *This method checks to see if the time is null or is an empty string
	 * throws an exception if the input is empty
	 * @param duration
	 * @return false if null or empty string and returns true otherwise
	 */
	public boolean check2(String duration) {
		boolean b =true;
		if (duration == null||duration=="") b=false;

		return b;

	}

	/**
	 * this method checks to see if theres more than 1 decimal points and if the time input
	 * by the user is over 24 hours, throws an exception
	 * @return
	 * @throws InvalidUserException
	 */

	public boolean check() throws InvalidUserException {
		{
			boolean b = true;
			int period_count_for_time = 0;


			for (char g: time.toCharArray()) {

				if (!Character.isDigit(g)) {
					if (g == '.') {

					} else {
						b = false;
						throw new InvalidUserException("Don't include the character: " + g + "." + " " + 
								" Time should be a number and should not have multiple '.'");

					}	
				}if (g == '.') {
					period_count_for_time += 1;

				}

			} 
			if (period_count_for_time > 1) {
				b = false;
				throw new InvalidUserException("Don't include the multiple periods: " + "." + "." + " " +
						"Time should be a number minutes. ");
			}	
			if (check2(time)) {
				double time = Double.parseDouble(this.time);
				if (time < 0 || time > 1440 ) {
					// checks to see if the number is within valid values
					b = false;
					throw new InvalidUserException("Time should be between 0 & 1440" + "." + " " + 
							"Invalid Time: " + this.time);			
				} } else {
					//if time is empty or null, throw that time textfield is empty
					throw new InvalidUserException("Time textfield is null");
				}


			return b;
		}
	}
}

