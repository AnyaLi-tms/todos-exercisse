package com.oocl.todos.repository;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;

import java.util.List;

public interface TodoRepository {
    Todo create(Todo todo);

    void delete(Long id);

    Todo update(Long id, Todo todo);

    Todo get(Long id);

    List<Todo> getAll(Integer page, Integer pageSize, Status status);
}
