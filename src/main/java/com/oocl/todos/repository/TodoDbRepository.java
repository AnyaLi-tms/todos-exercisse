package com.oocl.todos.repository;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;

import java.util.List;

public class TodoDbRepository implements TodoRepository {
    private JpaTodoRepository jpaTodoRepository;

    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Todo update(Long id, Todo todo) {
        return null;
    }

    @Override
    public Todo get(Long id) {
        return null;
    }

    @Override
    public List<Todo> getAll(Integer page, Integer pageSize, Status status) {
        return List.of();
    }
}
