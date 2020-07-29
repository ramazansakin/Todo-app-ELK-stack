package com.sakinramazan.userservice.repository;

import com.sakinramazan.userservice.entity.Address;
import com.sakinramazan.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getAllByAddress(Address address);

    List<User> getAllByAddress_City(String city);

    User getByEmail(String email);
}
