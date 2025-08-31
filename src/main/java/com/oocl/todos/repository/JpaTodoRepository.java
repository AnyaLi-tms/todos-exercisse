package com.oocl.todos.repository;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTodoRepository extends JpaRepository<Todo, Integer> {
    Page<Todo> findByStatus(Status status, Pageable pageable);
}