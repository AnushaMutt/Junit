package injectmocksexample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

class MainClassTest {

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	MainClass mainClass;
	
	@Mock
	DatabaseDAO dependentClassOne;
	
	@Mock
	NetworkDAO dependentClassTwo;
	
	@Test
	public void validateTest() {
		boolean saved = mainClass.save("temp.txt");
		assertEquals(true, saved);
		
		verify(dependentClassOne, times(1)).save("temp.txt");
		verify(dependentClassTwo, times(1)).save("temp.txt");
	}

}
