package application;

	import javafx.fxml.FXML;
	import javafx.scene.control.Label;



	public class UserWeightInputErrorHandling {
		
		String weight; 
		
		public UserWeightInputErrorHandling(String weight) {
			
			this.weight = weight;
			
					}	
		
		public boolean check () throws InvalidUserException
		{
			boolean b = true;
			
			int period_count_for_weight = 0;
			 
				
				
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
					
					
		        	double weight = Double.parseDouble(this.weight);
		        	
		        	if (weight < 0 || weight > 727 ) {
		        		b = false;
		        		throw new InvalidUserException("Weight should be between 0 & 727" + "." + " " + 
		        					"Invalid Weight: " + this.weight);	}
		        	
				return b;
		}
			     
			        	
			        	
			        	/*String getHeight() {
			        		return this.height;
			        	}
			        	
			        	String getWeight() {
			        		return this.weight;
			        	}*/
			        	
			    		
					}

