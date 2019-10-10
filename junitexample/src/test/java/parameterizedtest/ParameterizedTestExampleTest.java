package parameterizedtest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;
import java.util.EnumSet;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

@DisplayName("This class test ParameterizedTest Class")
class ParameterizedTestExampleTest {
	
	ParameterizedTestExample parameterizedTest;
	
	@BeforeEach
	void init() {
		parameterizedTest = new ParameterizedTestExample();
	}
	
	@DisplayName("This test isOdd method using Parameters")
	@ParameterizedTest
	@ValueSource(ints = {1,3,5,-3,15, Integer.MAX_VALUE}) 
	void testIsOdd(int number) {
		assertTrue(ParameterizedTestExample.isOdd(number));
	}
	
	@DisplayName("This test isBlack method")
	@ParameterizedTest
	@ValueSource(strings = {""," "})
	void testIsBlank(String input) {
		assertTrue(parameterizedTest.isBlank(input));
	}
	
	@DisplayName("This test with Enum Annotation")
	@ParameterizedTest
	@EnumSource(Month.class)
	void getValueForMonth(Month month) {
		int monthNumber = month.getValue();
		assertTrue(monthNumber >= 0 && monthNumber <=12);
	}
	
	@DisplayName("This test with Enum Annotation with filtered month")
	@ParameterizedTest
	@EnumSource(value = Month.class, names = {"APRIL","JUNE","SEPTEMBER","NOVEMBER"})
	void someMonths_Are30DaysLong(Month month) {
		final boolean isALeapYear = false;
		assertEquals(30, month.length(isALeapYear));
	}
	
	@DisplayName("This test Enum Annotation with regular Expression")
	@ParameterizedTest
	@EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
	void fourMonth_AreEndingWithBer(Month month) {
		EnumSet<Month> months= EnumSet.of(Month.SEPTEMBER,Month.OCTOBER,Month.NOVEMBER,Month.DECEMBER);
		assertTrue(months.contains(month));
	}
}
