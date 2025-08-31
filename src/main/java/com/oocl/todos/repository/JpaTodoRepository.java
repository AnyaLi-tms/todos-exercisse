package com.oocl.todos.repository;

import com.oocl.todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTodoRepository extends JpaRepository<Todo, Integer> {
}
