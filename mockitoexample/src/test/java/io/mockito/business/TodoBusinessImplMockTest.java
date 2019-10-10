package io.mockito.business;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

import io.mockito.api.TodoService;

@DisplayName("This test BusinessImpl")
class TodoBusinessImplMockTest {
	
	@Test
	void testRetriveTodosRelatedToSpring() {
		TodoService	todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring","Learn Boot","Learn MVC");
		
		when(todoServiceMock.retriveTodos("dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List <String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("dummy");
		assertEquals(1, filteredTodos.size());
	}
	
	@Test
	void testRetriveTodosRelatedToSpring2() {
		TodoService	todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retriveTodos("dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List <String> filteredTodos = todoBusinessImpl.retriveTodosRelatedToSpring("dummy");
		assertEquals(0, filteredTodos.size());
	}

}
