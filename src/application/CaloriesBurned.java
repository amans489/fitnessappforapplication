package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

//public class CaloriesBurned extends Application {
//	private double weight;
//	private int METenergy;
//	private double distance;
//	final static String monday = "Monday";
//    final static String tuesday = "Tuesday";
//    final static String wednesday = "Wednesday";
//    final static String thursday = "Thursday";
//    final static String friday = "Friday";
//    final static String saturday = "Saturday";
//    final static String sunday = "Sunday";
 



//	 CaloriesBurned(int energy, double run, double pounds){
//		 METenergy = energy;
//		 weight = pounds;
//		 distance = run;
//	 }

	 
	// public double calorieCalc (int MET, double distanceRan, double bodyW) {

	// double caloriesBurned = (MET*distanceRan*bodyW)/200;
	 //return caloriesBurned;
	 
//	 double getCalorieCalc() {
//	return (METenergy*weight*distance)/200;
//	 }
	 
	 
        
//        @Override public void start(Stage stage) {
//            stage.setTitle("Calories burned for Days of the week ");
//            final CategoryAxis xAxis = new CategoryAxis();
//            final NumberAxis yAxis = new NumberAxis();
//            final BarChart<String,Number> bc = 
//                new BarChart<String,Number>(xAxis,yAxis);
//            bc.setTitle("Calories burned for Days of the week ");
//            xAxis.setLabel("Days of the week: ");       
//            yAxis.setLabel("Calories Burned");
     
//            XYChart.Series caloriesBurned = new XYChart.Series();
//            caloriesBurned.setName("CaloriesBurned");       
//            caloriesBurned.getData().add(new XYChart.Data(monday, getCalorieCalc()));
//            caloriesBurned.getData().add(new XYChart.Data(tuesday,getCalorieCalc()));
//            caloriesBurned.getData().add(new XYChart.Data(wednesday, getCalorieCalc()));
//            caloriesBurned.getData().add(new XYChart.Data(thursday, getCalorieCalc()));
//            caloriesBurned.getData().add(new XYChart.Data(friday,getCalorieCalc()));
//            caloriesBurned.getData().add(new XYChart.Data(saturday, getCalorieCalc()));      
          
//            Scene scene  = new Scene(bc,800,600);
//            bc.getData().addAll(caloriesBurned);
//            stage.setScene(scene);
//            stage.show();
//        }
