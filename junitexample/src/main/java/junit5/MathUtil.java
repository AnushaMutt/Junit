package junit5;

public class MathUtil {
	
	public int add(int x,int y) {
		return x+y;
	}
	
	public int subtract(int x,int y) {
		return x-y;
	}
	
	public int multiply(int x,int y) {
		return x*y;
	}
	
	public double divide(int x,int y) {
		return x/y;
	}
	
	public double computeCirleArea(double radius) {
		return Math.PI * radius *radius;
	}
}
