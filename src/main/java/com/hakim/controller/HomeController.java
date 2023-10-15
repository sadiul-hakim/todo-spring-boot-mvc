package com.hakim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hakim.model.Todo;
import com.hakim.pojo.TodoSaveRequest;
import com.hakim.service.TodoService;

import jakarta.websocket.server.PathParam;

@Controller
public class HomeController {
	
	private final TodoService todoService;
	
	@Autowired
	public HomeController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("todos",todoService.getAllTodos());
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	@PostMapping("/save")
	public ModelAndView saveTodo(@ModelAttribute TodoSaveRequest saveRequest) {
		
		Todo todo = todoService.save(saveRequest);
		List<Todo> list= todoService.getAllTodos();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("todos",list);
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable long id) {
		
		todoService.delete(id);
		
		List<Todo> list= todoService.getAllTodos();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("todos",list);
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
}




