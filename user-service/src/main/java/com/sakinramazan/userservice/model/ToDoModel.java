package com.sakinramazan.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoModel {

    private Integer id;

    private String headline;

    private String details;
}
