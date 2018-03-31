package com.beamofsoul.cloud.bunny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "userServiceFallback", commandKey = "userKey")
	public String userService(String name) {
		
		long start = System.currentTimeMillis();
		
		String body = restTemplate.getForEntity("http://PROVIDER-USER/provider?name="+name, String.class).getBody();
		
		long end = System.currentTimeMillis();
		
		log.info("**** Spend time: " + (end - start));
		
		return body; 
	}
	
	public String userServiceFallback(String name) {
		return "error " + name;
	}
}
