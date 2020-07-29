package com.sakinramazan.userservice.service;

import com.sakinramazan.userservice.dto.UserDTO;
import com.sakinramazan.userservice.entity.Todo;
import com.sakinramazan.userservice.entity.User;
import com.sakinramazan.userservice.model.ToDoModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO getOne(Integer id);

    UserDTO getUserByEmail(String email);

    UserDTO addOne(@RequestBody User address);

    UserDTO updateOne(@RequestBody User address);

    Map<String, String> deleteOne(Integer id);

    List<ToDoModel> getAllToDosViaRestTemplate();

    List<UserDTO> getUsersByAddress(Integer address_id);

    List<UserDTO> getUsersByAddressCityName(String city);

}
