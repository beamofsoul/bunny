package com.beamofsoul.cloud.bunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beamofsoul.cloud.bunny.dto.User;
import com.beamofsoul.cloud.bunny.service.RefactorUserService;
import com.beamofsoul.cloud.bunny.service.UserService;

@RestController
public class ConsumerController {

	@Autowired
	UserService userService;
	
	@Autowired
	RefactorUserService refactorUserService;
	
	@GetMapping("/feign-consumer")
	public String helloConsumer(@RequestParam("name") String name) {
		return userService.provider(name);
	}
	
	@GetMapping("/feign-consumer2")
	public String helloConsumer2() {
		StringBuilder sb = new StringBuilder();
		sb.append(refactorUserService.hello("MIMI")).append("\n");
		sb.append(refactorUserService.hello("MIMI", 20)).append("\n");
		sb.append(refactorUserService.hello(new User("MIMI", 20))).append("\n");
		return sb.toString();
	}
}
