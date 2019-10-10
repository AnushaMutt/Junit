package parameterizedtest;

import static org.junit.Assert.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("FizzBuzz test Class")
class FizzBuzzTest {
	FizzBuzz fizzBuzz;
	
	@BeforeEach
	void init() {
	 fizzBuzz = new FizzBuzz();
	}
	
	@ParameterizedTest(name = "{index} => calculate({0})")
	@ValueSource(ints = {1,2,4,7,11,13,14})
	void returnsNumberNotDivisibleByThreeAndFive(int number) {
		
		assertEquals(""+number, fizzBuzz.calculate(number));
	}
	
	@ParameterizedTest(name = "{index} => calculate({0})")
	@MethodSource({"divisibleByThree", "divisibleByThreeButNotFive"})
	void returnFizzForNumberDivisiblebyThree(int number) {
		assertEquals("Fizz", fizzBuzz.calculate(number));
	}
	
	private static Stream<Integer> divisibleByThree(){
		return Stream.of(3,6,9,12);
	}
	
	private static String[] divisibleByThreeButNotFive() {
		return new String[] {"18","21"};
	}
	
	@ParameterizedTest(name= "{index} => calculate({0})")
	@MethodSource("fizzBuzz")
	void fizzBuzz(int number, String expected) {
		assertEquals(expected, fizzBuzz.calculate(number));
	}
	
	private static Stream<Arguments> fizzBuzz(){
		return Stream.of(
				Arguments.of(1,"1"),
				Arguments.of(2,"2"),
				Arguments.of(3,"Fizz"),
				Arguments.of(4,"4"),
				Arguments.of(5,"Buzz"),
				Arguments.of(6,"Fizz"),
				Arguments.of(7,"7"),
				Arguments.of(8,"8"),
				Arguments.of(9,"Fizz"),
				Arguments.of(15,"FizzBuzz")
				);
	}

}
