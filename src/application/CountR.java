package application;

public class CountR {

double weightR;
int METenergyR;
double durationR;



 CountR(int energy, double run, double pounds){
	
	 METenergyR = energy;
	 weightR = pounds;
	 durationR = run;
 }

 
// public double calorieCalc (int MET, double distanceRan, double bodyW) {

// double caloriesBurned = (MET*distanceRan*bodyW)/200;
 //return caloriesBurned;
 
 double getCalorieCalc() {
return (METenergyR*weightR*durationR)/200;
 }
 
 }
