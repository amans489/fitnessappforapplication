

package application;

public class CountR extends Exercise {
	private int METenergyW = 4;
	public CountR(double run, double pounds) {
		
		super(run, pounds);
		// TODO Auto-generated constructor stub
	}
	
	public int getMETenergyW() {
		return METenergyW;
	}

	@Override
	double getCalorieCalc() {

		return METenergyW*super.weight*super.duration/(200);
	}

}