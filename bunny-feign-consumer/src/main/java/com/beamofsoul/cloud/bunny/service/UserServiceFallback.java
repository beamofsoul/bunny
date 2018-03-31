package com.beamofsoul.cloud.bunny.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {

	@Override
	public String provider(String name) {
		return "error " + name;
	}
}
