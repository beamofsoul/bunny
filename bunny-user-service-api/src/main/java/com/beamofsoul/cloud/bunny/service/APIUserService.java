package com.beamofsoul.cloud.bunny.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beamofsoul.cloud.bunny.dto.User;

@RequestMapping("/refactor")
public interface APIUserService {

	@GetMapping("/hello1")
	String hello(@RequestParam("name") String name);
	
	@GetMapping("/hello2")
	User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@PostMapping("/hello3")
	String hello(@RequestBody User user);
}
