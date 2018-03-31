package com.beamofsoul.cloud.bunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beamofsoul.cloud.bunny.service.UserService;

@RestController
public class ConsumerController {
	
	@Autowired
    UserService userService;

	@GetMapping("/hi")
    public String hi(@RequestParam String name){
        return userService.userService(name);
    }
}
