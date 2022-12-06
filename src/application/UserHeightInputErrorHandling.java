
	package application;

	import javafx.fxml.FXML;
	import javafx.scene.control.Label;



	public class UserHeightInputErrorHandling {
		String height;
		 
		
		public UserHeightInputErrorHandling(String height) {
			
			this.height = height;
			
			
					}	
		
		public boolean check () throws InvalidUserException
		{
			boolean b = true;
			int period_count_for_height = 0;
			
			 
				for (char g: height.toCharArray()) {
					
					if (!Character.isDigit(g) && g != '.') {
						b = false;
						throw new InvalidUserException("Don't include the character: " + g + "." + " " + 
	    					" Height should be a number and should not have multiple '.'");
						
				
					}
				
				} 
				if (period_count_for_height > 1) {
					b = false;
	        		throw new InvalidUserException("Don't include the multiple periods: " + "." + "." + " " +
	        				"Height should be a number. ");
	    		}	
			

	        	double height = Double.parseDouble(this.height);
	        	if (height < 0 || height > 213.36 ) {
	        		b = false;
	        		throw new InvalidUserException("Height should be between 0 & 213.36" + "." + " " + 
	        					"Invalid Height: " + this.height);			
	        	}
				
				
			
				return b;
		}
			     
			        	
			        	
			        	/*String getHeight() {
			        		return this.height;
			        	}
			        	
			        	String getWeight() {
			        		return this.weight;
			        	}*/
			        	
			    		
					}

