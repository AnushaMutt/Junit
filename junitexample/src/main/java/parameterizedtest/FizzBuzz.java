package parameterizedtest;

public class FizzBuzz {
	public String calculate(int number) {
		
		if(isDivisibleByThree(number) && isDivisibleByFive(number)) {
			return "FizzBuzz";
		}
		
		if(isDivisibleByThree(number)) {
			return "Fizz";
		}
		
		if(isDivisibleByFive(number)) {
			return "Buzz";
		}
		
		return String.valueOf(number);
	}

	private static boolean isDivisibleByFive(int number) {
		
		return isDivisibleBy(number, 5);
	}

	private boolean isDivisibleByThree(int number) {
		
		return isDivisibleBy(number, 3);
	}
	
	private static boolean isDivisibleBy(int dividend, int divisior) {
		
		return dividend % divisior ==0;
	}
}
