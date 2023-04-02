public class Calculator {
	
	private double value;
	
	public Calculator() {
		value = 0;
	}
	
	public Calculator(double val) {
		value = val;
	}
	
	public void add(double val) {
		value += val;
	}	
	
	public void subtract(double val) {
		value -= val;
	}
	
	public void multiply(double val) {
		value *= val;
	}
	
	public void divide(double val) {
		value /= val;
	}
	
	public void clear () {
		value = 0;
	}
	
	public void setValue(double val) {
		value = val;
	}
	
	public double getValue() {
		return value;
	}
}