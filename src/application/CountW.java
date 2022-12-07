package application;

public class CountW extends Exercise {
	private int METenergyW = 4;
	public CountW(double jog, double pounds) {
		
		super(jog, pounds);
		// TODO Auto-generated constructor stub
	}
	
	public int getMETenergyW() {
		return METenergyW;
	}

	@Override
	double getCalorieCalc() {
		// TODO Auto-generated method stub
		return METenergyW*super.weight*super.duration/(200);
	}

}
