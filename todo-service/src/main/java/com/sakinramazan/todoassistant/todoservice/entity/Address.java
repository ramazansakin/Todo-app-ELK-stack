package com.sakinramazan.todoassistant.todoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "{validation.messages.address.city}")
    private String city;

    private String street;

    @Column(name = "building_no")
    private Integer buildingNo;

    @Column(name = "door_no")
    private Integer doorNo;

}
