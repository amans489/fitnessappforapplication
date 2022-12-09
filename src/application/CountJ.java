package application;

public class CountJ extends Exercise {
	private int METenergyW = 4;
	public CountJ(double jog, double pounds) {
		
		super(jog, pounds);
		
	}
	
	public int getMETenergyW() {
		return METenergyW;
	}

	@Override
	double getCalorieCalc() {
		return METenergyW*super.weight*super.duration/(200);
	}

}