package com.sakinramazan.todoassistant.todoservice.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@Api(value = "TestController")
public class TestController {

    @GetMapping("{sample.url}")
    public String getCenteralizeConfigSreverTest() {
        return "Hello from Git server";
    }

    @GetMapping("test")
    public String getTest() {
        return "Hello from Test api";
    }
}
