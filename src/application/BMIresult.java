package application;

public interface BMIresult {
	public String bmitype(bmiresult) {
	String type;
	if (bmi < 15)  {
		type = "very severely underweight";
	} else if (bmi == 15 || bmi < 16) {
		type = "Severely underweight";
	} else if (bmi == 16 || bmi < 18.5) {
		type = "Underweight";
	} else if (bmi == 18.5 || bmi < 25) {
		type = "normal";
	} else if (bmi == 25 || bmi < 30) {
		type = "overweight";
	} else if (bmi == 30 || bmi < 35) {
		type = "moderately obese";
	} else if (bmi == 35 || bmi < 40) {
		type = "severely obese";
	} else if (bmi >= 40) {
		type = "very severely obese";
	}
	return type;
 }