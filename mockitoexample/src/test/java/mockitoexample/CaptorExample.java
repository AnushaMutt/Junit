package mockitoexample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

class CaptorExample {

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	List<String> mockList;
	
	@Test
	void whenNotUseCaptorAnnotation_thenCorrect() {
		ArgumentCaptor<String> args= ArgumentCaptor.forClass(String.class);
		
		mockList.add("one");
		verify(mockList).add(args.capture());
		
		assertEquals("one", args.getValue());
	}
	
	@Captor
	ArgumentCaptor<String> agrCaptor;
	
	@Test
	public void whenUseCaptorAnnotation() {
		mockList.add("one");
		
		verify(mockList).add(agrCaptor.capture());
		
		assertEquals("one", agrCaptor.getValue());
	}

}
