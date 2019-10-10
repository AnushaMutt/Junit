package methodresourceexample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import parameterizedtest.ParameterizedTestExample;

class MethodResourceExample {

	ParameterizedTestExample parameterizedtest;
	
	@BeforeEach
	void init() {
		parameterizedtest = new ParameterizedTestExample();
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsForIsBlank")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
	    assertEquals(expected, parameterizedtest.isBlank(input));
	}
	
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideStringsForIsBlank(){
		return Stream.of(
			Arguments.of(null,true),
			Arguments.of("",true),
			Arguments.of(" ",true),
			Arguments.of("not blank",false)
			);
	}
	
	@ParameterizedTest
	@MethodSource
	void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
		assertTrue(parameterizedtest.isBlank(input));
	}
	
	@SuppressWarnings("unused")
	private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(){
		return Stream.of(null,""," ");
	}
	
	
}
