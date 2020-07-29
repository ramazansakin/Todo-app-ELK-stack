package com.sakinramazan.todoassistant.todoservice.exception;

public class ToDoNotFoundException extends NotFoundException {
    public ToDoNotFoundException(Integer id) {
        super("ToDo not found by id : " + id);
    }
}
