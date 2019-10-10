package mockitoexample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


@DisplayName("First Mockito test Class")

class FirstMockTest {
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	@Mock
	List<String> mockList;
	
	@DisplayName("List Test")
	@Test
	void testList() {
		
		mockList.add("one");
		System.out.print(mockList.size());
		verify(mockList).add("one");
		assertEquals(0, mockList.size());
		
		when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
	}
	
	@DisplayName("When not use Spy Annotation")
	@Test
	void whenNotUseSpyAnnotation() {
		List<String> spyList = spy(new ArrayList<>());
		
		spyList.add("one");
		spyList.add("two");
		
		verify(spyList).add("one");
		verify(spyList).add("two");
		
		assertEquals(2, spyList.size());
		
		when(spyList.size()).thenReturn(100);
		assertEquals(100, spyList.size());
	}
	
	@Spy
	List<String> spyList = new ArrayList<String>();
	
	@DisplayName("When use Spy Annotation")
	@Test
	void whenUseSpyAnnotation() {
		spyList.add("one");
		spyList.add("two");
		
		verify(spyList).add("one");
		verify(spyList).add("two");
		
		assertEquals(2, spyList.size());
		
		when(spyList.size()).thenReturn(100);
		assertEquals(100, spyList.size());
		
	}

}
