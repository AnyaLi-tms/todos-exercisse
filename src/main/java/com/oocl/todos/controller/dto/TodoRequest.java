package com.oocl.todos.controller.dto;

import com.oocl.todos.model.Status;
import jakarta.validation.constraints.NotNull;

public class TodoRequest {
    @NotNull(message = "Title cannot be null")
    private String title;
    private Status status;

    public TodoRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
