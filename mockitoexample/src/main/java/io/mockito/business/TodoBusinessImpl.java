package io.mockito.business;

import java.util.*;

import io.mockito.api.TodoService;

//TodoBusinessImpl => SystemUnderTest (SUT)
//TodoService => Dependency
public class TodoBusinessImpl {
	private TodoService todoService;
	
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retriveTodosRelatedToSpring(String user){
		
		List <String> filterdTodos = new ArrayList<String>();
		List<String> todos = todoService.retriveTodos(user);
		for(String todo : todos) {
			if(todo.contains("Spring")) {
				filterdTodos.add(todo);
			}
		}
		return filterdTodos;
	}
}
