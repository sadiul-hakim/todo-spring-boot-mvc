package com.hakim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakim.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
}
