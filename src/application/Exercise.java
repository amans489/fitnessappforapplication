package application;

public abstract class Exercise {
	double weight;
	
	double duration;



	 Exercise(double jog, double pounds){
		 
		 weight = pounds;
		 duration = jog;
	 }

	 
	// public double calorieCalc (int MET, double distanceRan, double bodyW) {

	// double caloriesBurned = (MET*distanceRan*bodyW)/200;
	 //return caloriesBurned;
	 
	 abstract double getCalorieCalc();
}

