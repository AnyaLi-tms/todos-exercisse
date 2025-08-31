package com.oocl.todos.repository;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;

import java.util.List;

public interface TodoRepository {
    Todo create(Todo todo);

    void delete(Integer id);

    Todo update(Integer id, Todo todo);

    Todo get(Integer id);

    List<Todo> getAll(Integer page, Integer pageSize, Status status);
}
