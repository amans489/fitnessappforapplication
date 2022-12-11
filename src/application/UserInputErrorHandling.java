package application;

	import javafx.fxml.FXML;
	import javafx.scene.control.Label;
	
	/**
	 * This is an error handling class for invalid height and weight values
	 * Will display an error message if the input is invalid
	 * @author Alina, Kaleigh, Marzia
	 *
	 */


	public class UserInputErrorHandling {
		
		/**
		 * instance variable for the weight and height input by the user
		 */
		String height;
		String weight; 
		
		/**
		 * A constructor that sets the instance values for height and weight 
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
		 * if they are both null return false for further handling
		 * @param heightAndWeight
		 * @return boolean state of whether height and weight are null
		 */
		public boolean check2(String heightAndWeight) {
			boolean b = true;
			if (heightAndWeight == null || heightAndWeight =="")
				b = false;
			return b;
		}
		
		/**
		 * The method that checks for proper syntax of the input made by the user
		 * It handles errors such as alphabetical characters, values not possible for 
		 * human height and weight
		 * @return boolean state of whether theres an exception or not
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
	    			double heightofuser = Double.parseDouble(this.height);
		        	if (heightofuser < 0 || heightofuser > 2.8 ) {
		        		b = false;
		        		throw new InvalidUserException("Height should be between 0 & 2.8(m)" + "." + " " + 
		        					"Invalid Height: " + this.height);	
	    		}} else {
	    			throw new InvalidUserException("Height TextField is empty");
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
						double weightofuser = Double.parseDouble(this.weight);
			        	
			        	if (weightofuser < 0 || weightofuser > 635 ) {
			        		b = false;
			        		throw new InvalidUserException("Weight should be between 0 & 635" + "." + " " + 
			        					"Invalid Weight: " + this.weight);	}
					} else {
						throw new InvalidUserException("Weight Textfield is empty");
					}
		        
		        	
				return b;
		}
			     
			        	
			        	
			    
			        	
			    		
					}
