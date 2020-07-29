package com.sakinramazan.todoassistant.todoservice.controller;

import com.sakinramazan.todoassistant.todoservice.entity.Todo;
import com.sakinramazan.todoassistant.todoservice.service.TodoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
@Slf4j
@CrossOrigin("*")
@Api(value = "TodoController")
public class TodoController {

    @Value("${server.port}")
    private int port;

    private final TodoService todoService;

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos() {
        log.info("All ToDo response via server port : " + port);
        List<Todo> all = todoService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable @Range(min = 1, max = 200) Integer id) {
        Todo one = todoService.getOne(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @PostMapping("/new-todo")
    public ResponseEntity<Todo> saveTodo(@Valid @RequestBody Todo todo) {
        Todo todo1 = todoService.addOne(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @PutMapping("/update-todo")
    public ResponseEntity<Todo> updateTodo(@RequestBody @Valid Todo todo) {
        Todo todo1 = todoService.updateOne(todo);
        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable @Range(min = 1, max = 200) Integer id) {
        Boolean status = todoService.deleteOne(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/get-todo/{headline}")
    public ResponseEntity<Todo> getByHeadline(@PathVariable String headline) {
        Todo byHeadline = todoService.getByHeadline(headline);
        return new ResponseEntity<>(byHeadline, HttpStatus.OK);
    }

    @GetMapping("/get-todos-by-user/{id}")
    public ResponseEntity<List<Todo>> getAllToDosByUser(@PathVariable @Range(min = 1, max = 200) Integer id) {
        List<Todo> allToDosByUser = todoService.getAllToDosByUser(id);
        return new ResponseEntity<>(allToDosByUser, HttpStatus.OK);
    }
}
