package com.oocl.todos.repository;

import com.oocl.todos.model.Status;
import com.oocl.todos.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDbRepository implements TodoRepository {
    JpaTodoRepository repository;

    public TodoDbRepository(JpaTodoRepository jpaTodoRepository) {
        this.repository = jpaTodoRepository;
    }

    @Override
    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Todo update(Integer id, Todo todo) {
        if (repository.existsById(id)) {
            todo.setId(id);
            repository.save(todo);
        }
        return todo;
    }

    @Override
    public Todo get(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Todo> getAll(Integer page, Integer pageSize, Status status) {
        Pageable pageable = PageRequest.of(page == null || page < 1 ? 0 : page - 1,
                pageSize == null || pageSize < 1 ? 5 : pageSize);
        Page<Todo> todoPage;
        if (status == null) {
            todoPage = repository.findAll(pageable);
        } else {
            todoPage = repository.findByStatus(status, pageable);
        }
        return todoPage.getContent();
    }
}
