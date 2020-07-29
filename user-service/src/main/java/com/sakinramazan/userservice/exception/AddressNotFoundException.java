package com.sakinramazan.userservice.exception;

public class AddressNotFoundException extends NotFoundException {
    public AddressNotFoundException(Integer id) {
        super("Address not found by id : " + id);
    }
}
