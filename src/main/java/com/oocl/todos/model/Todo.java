package com.oocl.todos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO; // TODO, DOING, DONE

    public Todo() {}

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String title, Status status) {
        this.title = title;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
