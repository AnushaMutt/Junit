package mockitoexample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.verify;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class SpyAndMockExample {

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	List<String> mockList;
	
	@DisplayName("Test with Mock Annotation")
	@Test
	void testWithMockAnnotation() {
		
		mockList.add("one");
		mockList.add("two");
		
		verify(mockList).add("one");
		verify(mockList).add("two");
		
		assertEquals(0, mockList.size());
	}
	
	@Spy
	List<String> spyList = new ArrayList<>();
	
	@DisplayName("Test with Spy Annotation")
	@Test
	void testWithSpyAnnotation() {
		
		spyList.add("one");
		spyList.add("two");
		
		verify(spyList).add("one");
		verify(spyList).add("two");
		
		assertEquals(2, spyList.size());
	}
	
	
}
