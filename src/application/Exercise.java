package application;

public class Exercise {
	double weight;
	int METenergy;
	double duration;



	 Exercise(int energy, double jog, double pounds){
		 METenergy = energy;
		 weight = pounds;
		 duration = jog;
	 }

	 
	// public double calorieCalc (int MET, double distanceRan, double bodyW) {

	// double caloriesBurned = (MET*distanceRan*bodyW)/200;
	 //return caloriesBurned;
	 
	 double getCalorieCalc() {
	return (METenergy*weight*duration)/200;
	 }
}

