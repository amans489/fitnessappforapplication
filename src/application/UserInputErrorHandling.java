
	package application;

	import javafx.fxml.FXML;
	import javafx.scene.control.Label;



	public class UserInputErrorHandling {
		String height;
		String weight; 
		
		public UserInputErrorHandling(String height,String weight) {
			 System.out.println(height + weight);
			this.height = height;
			this.weight = weight;
			
					}	
		
		public boolean check2(String heightAndWeight)
		{
			boolean b = true;
			if (heightAndWeight == null || heightAndWeight == "")
				b = false;
			return b;
		}
		
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
						period_count_for_height += 1;
		    			
				}
				
				} 
				if (period_count_for_height > 1) {
					b = false;
	        		throw new InvalidUserException("Don't include the multiple periods: " + "." + "." + " " +
	        				"Height should be a number. ");
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
				if (period_count_for_weight > 1) {
	    			b = false;
	        		throw new InvalidUserException("Don't include the multiple periods: " + "." + "." + " " +
	        				"Weight should be a number. ");
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
			     
			        	
			        	
			        	/*String getHeight() {
			        		return this.height;
			        	}
			        	
			        	String getWeight() {
			        		return this.weight;
			        	}*/
			        	
			    		
					}

