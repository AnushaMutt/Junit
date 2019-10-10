package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("This class test AssertArrayEqual class")
class AssertArrayEqualExampleTest {

	AssertArrayEqualExample assertArrayEqualExample;
	
	@BeforeEach
	void init() {
		assertArrayEqualExample = new AssertArrayEqualExample();
	}
	@DisplayName("This test the method")
	@Test
	void testConcatenateStringArrays() {
		final String[] input1= new String[] {"myString2"};
		final String[] input2= new String[] {"myString1","myString2"};
		
		assertArrayEquals(input1, AssertArrayEqualExample.concatenateStringArrays(input1, null));
		assertArrayEquals(input2, AssertArrayEqualExample.concatenateStringArrays(null, input2));
	}

}
