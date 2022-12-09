package application;

	import javafx.fxml.FXML;
	import javafx.scene.control.Label;

	public class TimeInputErrorHandling {
		String time;
		 
		
		public TimeInputErrorHandling(String timing) {
			
			this.time = timing;
			
			
					}	
		
		public boolean check () throws InvalidUserException
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

	        	double time = Double.parseDouble(this.time);
	        	if (time < 0 || time > 1440 ) {
	        		b = false;
	        		throw new InvalidUserException("Time should be between 0 & 1440 minutes" + "." + " " + 
	        					"Invalid Time: " + this.time + " minutes.");			
	        	}
				
				
			
		        	
				return b;
		}
	}