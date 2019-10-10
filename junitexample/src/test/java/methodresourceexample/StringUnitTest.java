package methodresourceexample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import parameterizedtest.ParameterizedTestExample;
import methodresourceexample.BlankStringsArgumentsProvider;
public class StringUnitTest {
	
	@ParameterizedTest
	@ArgumentsSource(BlankStringsArgumentsProvider.class)
	void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input) {
		ParameterizedTestExample parameterizedTest = new ParameterizedTestExample();
		assertTrue(parameterizedTest.isBlank(input));
	}
}
