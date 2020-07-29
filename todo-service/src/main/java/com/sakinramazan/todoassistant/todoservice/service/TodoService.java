package com.sakinramazan.todoassistant.todoservice.service;

import com.sakinramazan.todoassistant.todoservice.entity.Todo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    Todo getOne(Integer id);

    Todo addOne(@RequestBody Todo todo);

    Todo updateOne(@RequestBody Todo todo);

    boolean deleteOne(Integer id);

    Todo getByHeadline(String headline);

    List<Todo> getAllToDosByUser(@PathVariable Integer id);
}
