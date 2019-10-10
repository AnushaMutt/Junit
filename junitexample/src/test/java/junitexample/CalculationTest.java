package junitexample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("Clacuation test class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculationTest {
	Calculation calculation;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all..");
	}
	
	@BeforeEach
	void init() {
		System.out.println("Before Each test..");
		 calculation = new Calculation();
	}
	
	@Nested
	@DisplayName("Test Add inner Class")
	class AddTest{
		
		@DisplayName("Test Add() +ve")
		@Test
		void testAddPositive() {
			assertEquals(2, calculation.add(1, 1));
		}
		
		@DisplayName("Test Add() -ve")
		@Test
		void testAddNegative() {
			assertEquals(-2, calculation.add(-1, -1));
		}
	}
	
	
	
	//assertAll()
	@DisplayName("Test Multiply Method()")
	@Test
	void testMultiply() {
		assertAll(
				() -> assertEquals(4, calculation.multiply(2, 2)),
				() -> assertEquals(0, calculation.multiply(2, 0)),
				() -> assertEquals(-1, calculation.multiply(1, -1))
				);
	}
	
	@DisplayName("Test Divide()")
	@Test
	void testDivide(){
		assertThrows(ArithmeticException.class, () -> calculation.divide(1, 0));
	}
	
	@DisplayName("Test ComputeCircleArea()")
	@RepeatedTest(3)
	void testCompiteCircleArea() {
		assertEquals(314.1592653589793, calculation.compiteCircleArea(10), () -> "Should return rigth circle area");
	}
	
	@Disabled
	@DisplayName("Test Disabled Method")
	@Test
	void testDisabled() {
		fail("This test should be failed");
	}
	
	
	@AfterEach
	void cleanUp() {
		System.out.println("CLean up...");
	}
	
	@AfterAll
	static void afterAllMethod() {
		System.out.println("This need to tun after all....");
	}
}



