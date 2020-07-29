package com.sakinramazan.userservice.service;

import com.sakinramazan.userservice.entity.Address;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    Address getOne(Integer id);

    Address addOne(@RequestBody Address address);

    Address updateOne(@RequestBody Address address);

    boolean deleteOne(Integer id);
}
