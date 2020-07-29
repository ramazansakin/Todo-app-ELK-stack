package com.sakinramazan.todoassistant.todoservice.service.impl;

import com.sakinramazan.todoassistant.todoservice.entity.Todo;
import com.sakinramazan.todoassistant.todoservice.exception.ToDoNotFoundException;
import com.sakinramazan.todoassistant.todoservice.repository.TodoRepository;
import com.sakinramazan.todoassistant.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getOne(Integer id) {
        Optional<Todo> byId = todoRepository.findById(id);
        return byId.orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @Override
    public Todo addOne(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateOne(Todo todo) {
        if (todo.getId() == null)
            throw new RuntimeException("ToDo entity must include id field");
        getOne(todo.getId());
        return todoRepository.save(todo);
    }

    @Override
    public boolean deleteOne(Integer id) {
        todoRepository.delete(getOne(id));
        return true;
    }

    @Override
    public Todo getByHeadline(String headline) {
        return todoRepository.getByHeadline(headline);
    }

    @Override
    public List<Todo> getAllToDosByUser(Integer id) {
        return todoRepository.getAllByUserId(id);
    }
}
