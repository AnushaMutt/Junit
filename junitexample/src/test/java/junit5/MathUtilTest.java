package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("This class test MathUtil class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest {
	
	MathUtil mathUtil;
	
	@BeforeAll
	void beforeAllInit() {
		System.out.println("This run before all...");
	}
	
	@BeforeEach
	void init() {
		mathUtil = new MathUtil();
	}
	
	@Nested
	@DisplayName("This is inner Add test Class")
	class AddTest{
		
		@DisplayName("This test add() +ve")
		@Test
		void testAdd() {
			assertEquals(2, mathUtil.add(1, 1));
		}
		
		@DisplayName("This test add() -ve")
		@Test
		void testAddNegative() {
			assertEquals(-2, mathUtil.add(3, -5));
		}
	}
	
	@DisplayName("This test subtract()")
	@Test
	void testSubtract() {
		assertEquals(-1, mathUtil.subtract(1, 2));
	}
	
	@DisplayName("This test Multiply")
	@Test
	void testMultiply() {
		assertAll(
			() ->	assertEquals(3, mathUtil.multiply(1, 3)),
			() -> assertEquals(0, mathUtil.multiply(2, 0)),
			() -> assertEquals(-1, mathUtil.multiply(1, -1))
			);
	}
	
	@DisplayName("This test Divide")
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0));
	}
	
	@RepeatedTest(3)
	@DisplayName("This test circleArea()")
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtil.computeCirleArea(10));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Clean up...");
	}
	
	@AfterAll
	void tearDownAll() {
		System.out.println("This run after all..");
	}
}
