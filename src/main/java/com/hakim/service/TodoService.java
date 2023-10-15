package com.hakim.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakim.model.Todo;
import com.hakim.pojo.TodoSaveRequest;
import com.hakim.repository.TodoRepository;

@Service
public class TodoService {
	
	private final TodoRepository repository;
	
	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.repository = todoRepository;
	}

	public Todo save(TodoSaveRequest request) {
		Todo todo = new Todo();
		todo.setContent(request.getContent());
		todo.setDate(new Date(System.currentTimeMillis()));
		
		return repository.save(todo);
	}
	
	public Todo getById(long id) {
		return repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Could not find todo by id: "+id));
	}
	
	public List<Todo> getAllTodos(){
		return repository.findAll();
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
}
