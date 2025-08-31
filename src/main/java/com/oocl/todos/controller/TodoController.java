package com.oocl.todos.controller;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;
import com.oocl.todos.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Integer id) {
        return todoService.getTodo(id);
    }

    @GetMapping()
    public List<Todo> getTodos(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Status status
    ) {
        return todoService.getTodos(page, pageSize, status);
    }
}
