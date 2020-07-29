package com.sakinramazan.todoassistant.todoservice.repository;

import com.sakinramazan.todoassistant.todoservice.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    Todo getByHeadline(String headline);

    List<Todo> getAllByUserId(Integer userId);

    List<Todo> getAllByUserIdAndHeadline(Integer userId, String headline);
}
