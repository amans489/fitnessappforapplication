package application;

public class CountW {
	double weightW;
	int METenergyW;
	double durationW;



	 CountW(int energy, double jog, double pounds){
		 METenergyW = energy;
		 weightW = pounds;
		 durationW = jog;
	 }

	 
	// public double calorieCalc (int MET, double distanceRan, double bodyW) {

	// double caloriesBurned = (MET*distanceRan*bodyW)/200;
	 //return caloriesBurned;
	 
	 double getCalorieCalc() {
	return (METenergyW*weightW*durationW)/200;
	 }

}
