package com.oocl.todos.controller.mapper;

import com.oocl.todos.controller.dto.TodoRequest;
import com.oocl.todos.controller.dto.TodoResponse;
import com.oocl.todos.model.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper {
    public Todo toEntity(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);
        return todo;
    }

    public TodoResponse toResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(todo, todoResponse);
        return todoResponse;
    }

    public List<TodoResponse> toResponse(List<Todo> todos) {
        return todos.stream().map(this::toResponse).toList();
    }
}
