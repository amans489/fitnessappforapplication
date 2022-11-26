package application;

public class CountJ {
	
	double weightJ;
	int METenergyJ;
	double durationJ;



	 CountJ(int energy, double jog, double pounds){
		 METenergyJ = energy;
		 weightJ = pounds;
		 durationJ = jog;
	 }

	 
	// public double calorieCalc (int MET, double distanceRan, double bodyW) {

	// double caloriesBurned = (MET*distanceRan*bodyW)/200;
	 //return caloriesBurned;
	 
	 double getCalorieCalc() {
	return (METenergyJ*weightJ*durationJ)/200;
	 }
}