package com.oocl.todos.controller;

import com.oocl.todos.controller.dto.TodoRequest;
import com.oocl.todos.controller.dto.TodoResponse;
import com.oocl.todos.controller.mapper.TodoMapper;
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
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse createTodo(@RequestBody TodoRequest todoRequest) {
        Todo todo = todoMapper.toEntity(todoRequest);
        return todoMapper.toResponse(todoService.createTodo(todo));
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
    public TodoResponse getTodo(@PathVariable Integer id) {
        return todoMapper.toResponse(todoService.getTodo(id));
    }

    @GetMapping()
    public List<TodoResponse> getTodos(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Status status
    ) {
        return todoMapper.toResponse(todoService.getTodos(page, pageSize, status));
    }
}