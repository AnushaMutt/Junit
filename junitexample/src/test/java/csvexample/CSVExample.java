package csvexample;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class CSVExample {
	
	
	@ParameterizedTest
	@CsvSource({"test,TEST","tEst,TEST","Java,JAVA"}) //CSV with comma separator
	void upperCaseTest(String input1,String input2) {
		String actualValue = input1.toUpperCase();
		assertEquals(input2, actualValue);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"test:test","tesT:test","JAva:java"},delimiter = ':') //CSV with : Delimiter
	void lowerCaseTest_WithOtherDelimeter(String input, String expected) {
		String actualValue = input.toLowerCase();
		assertEquals(expected, actualValue);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "./data.csv", numLinesToSkip = 1)
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(String input, String expected) {
	    String actualValue = input.toUpperCase();
	    assertEquals(expected, actualValue);
	}

}
