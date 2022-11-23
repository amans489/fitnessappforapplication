package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class CaloriesBurned extends Application {
	
	final static String monday = "Monday";
   final static String tuesday = "Tuesday";
   final static String wednesday = "Wednesday";
   final static String thursday = "Thursday";
   final static String friday = "Friday";
    final static String saturday = "Saturday";
    final static String sunday = "Sunday";
 




	 
        
        @Override public void start(Stage stage) {
            stage.setTitle("Calories burned for Days of the week ");
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            final BarChart<String,Number> caloriesburned = 
                new BarChart<String,Number>(xAxis,yAxis);
            caloriesburned.setTitle("Calories burned for Days of the week ");
            xAxis.setLabel("Days of the week: ");       
            yAxis.setLabel("Calories Burned");
     
            XYChart.Series caloriesBurned = new XYChart.Series();
           caloriesBurned.setName("CaloriesBurned");       
            caloriesBurned.getData().add(new XYChart.Data(monday, 2000));
           caloriesBurned.getData().add(new XYChart.Data(tuesday,3000));
           caloriesBurned.getData().add(new XYChart.Data(wednesday,5000));
           caloriesBurned.getData().add(new XYChart.Data(thursday, 7000));
            caloriesBurned.getData().add(new XYChart.Data(friday,1000));
            caloriesBurned.getData().add(new XYChart.Data(saturday, 20000));      
          
            Scene scene  = new Scene(caloriesburned,800,600);
            caloriesburned.getData().addAll(caloriesBurned);
           stage.setScene(scene);
           stage.show();
        }
        public static void main(String[] args) {
        	launch(args);
        }
	 }
