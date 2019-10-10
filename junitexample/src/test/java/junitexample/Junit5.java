package junitexample;

import org.junit.jupiter.api.*;


@DisplayName("Junit5 - Test Basic")
public class Junit5 {
	
		@BeforeAll 
		static void beforeAll() {
			System.out.println("Before All test(once)");
		}
		
		@BeforeEach
		void beforeEach() {
			System.out.println("Runs before each test");
		}
		
		@Test
		void standardTest() {
			System.out.println("test is running");
		}
		
		
		@DisplayName("My #2 Junit test")
		@Test
		void testWithcustomDisplay() {
			System.out.println("Test is running");
		}
		
		@DisplayName("Tagged Junit5 test")
		@Tag("Cool")
		@Test
		void tagged() {
			System.out.println("Test is running");
		}
		
		@Disabled("Failing due to unknown reason")
		@DisplayName("Disabled test")
		@Test
		void disabledTest() {
			System.out.println("Disabled, will not show up");
		}
		
		@AfterEach
		void afterEach() {
			System.out.println("Runs after each test");
		}
}
