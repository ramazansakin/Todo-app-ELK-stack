package com.sakinramazan.userservice.controller;

import com.sakinramazan.userservice.entity.Address;
import com.sakinramazan.userservice.service.AddressService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/address")
@Api(value = "AddressController")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAll() {
        List<Address> all = addressService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> get(@PathVariable @Range(min = 1, max = 100) Integer id) {
        Address one = addressService.getOne(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Address> save(@RequestBody @Valid Address address) {
        Address actual = addressService.addOne(address);
        return new ResponseEntity<>(actual, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody @Valid Address address) {
        Address actual = addressService.updateOne(address);
        return new ResponseEntity<>(actual, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable @Range(min = 1, max = 100) Integer id) {
        Boolean status = addressService.deleteOne(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
