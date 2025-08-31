package com.oocl.todos.service;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;
import com.oocl.todos.repository.TodoDbRepository;
import com.oocl.todos.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoDbRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.create(todo);
    }

    public void deleteTodo(Integer id) {
        todoRepository.delete(id);
    }

    public void updateTodo(Integer id, Todo todo) {
        todoRepository.update(id, todo);
    }

    public Todo getTodo(Integer id) {
        return todoRepository.get(id);
    }

    public List<Todo> getTodos(Integer page, Integer pageSize, Status status) {
        return todoRepository.getAll(page, pageSize, status);
    }
}
