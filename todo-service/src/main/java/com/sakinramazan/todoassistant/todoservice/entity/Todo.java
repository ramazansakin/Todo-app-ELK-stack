package com.sakinramazan.todoassistant.todoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "{validation.messages.todo.headline}")
    private String headline;

    private String details;

    // you can edit max or min value for validation
    // or you can add any other built-in validaiton annotation
    // such as
    // @Pattern(regex = "[0-9]+")
    // OR
    // @RegExp("[0-9]+")
    @Column(name = "user_id")
    @Range(min = 1, max = 200)
    private Integer userId;

}
