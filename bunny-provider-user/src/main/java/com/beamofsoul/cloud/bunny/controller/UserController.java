package com.beamofsoul.cloud.bunny.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	
//	@Value("${server.port}")
//	String port;

	@Autowired
    private Registration registration; // 服务注册
	
	@Autowired
	private DiscoveryClient client; // 服务发现客户端
	
	@GetMapping("/provider")
	public String provider(@RequestParam String name) throws InterruptedException {
		List<ServiceInstance> serviceInstances = client.getInstances(registration.getServiceId());
		if (serviceInstances != null && serviceInstances.size() > 0) {
			ServiceInstance instance = serviceInstances.get(0);
			
			int sleepTime = new Random().nextInt(3000);
			log.info("**** sleepTime: " + sleepTime);
			Thread.sleep(sleepTime);
			
			log.info("#### provider service id = " + instance.getServiceId());
			log.info("#### provider service host = " + instance.getHost());
			
			return "Hello " + name + ", this is from port: " + instance.getPort();
		}
		return "Hello " + name;
		
	}
}
