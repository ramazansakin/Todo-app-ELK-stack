package com.sakinramazan.userservice.dto;

import com.sakinramazan.userservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private Address address;

//    I want to hide user password and address
//    and just we need to do that is defining DTO
//    private String password;

}
