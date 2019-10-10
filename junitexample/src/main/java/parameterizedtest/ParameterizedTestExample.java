package parameterizedtest;

public class ParameterizedTestExample {
	
	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}
	
	public boolean isBlank(String input) {
		return input == null || input.trim().isEmpty();
	}
}
