package application;

public class CountR {

double weight;
int METenergy;
double distance;



 CountR(int energy, double run, double pounds){
	 METenergy = energy;
	 weight = pounds;
	 distance = run;
 }

 
// public double calorieCalc (int MET, double distanceRan, double bodyW) {

// double caloriesBurned = (MET*distanceRan*bodyW)/200;
 //return caloriesBurned;
 
 double getCalorieCalc() {
return (METenergy*weight*distance)/200;
 }
 
 }