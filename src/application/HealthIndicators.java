package application;

public class HealthIndicators {
	private double heightvalue;
	private double weightvalue;
	private double bmi;
	
	public HealthIndicators(String height,String weight) {
		heightvalue = Double.parseDouble(height);
		weightvalue = Double.parseDouble(weight);
	}
	
	public double getBMI() {
		return bmi = weightvalue / ((heightvalue) * (heightvalue));
	}
}
	
	