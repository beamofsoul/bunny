package com.beamofsoul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class BunnySleuthTrace1Application {
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/trace-1")
	public String trace() {
		log.info("=== call trace-1 ===");
		return this.restTemplate().getForEntity("http://trace-2/trace-2", String.class).getBody();
	}
	
//	@Bean
//	public AlwaysSampler defaultSampler() {
//		return new AlwaysSampler();
//	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BunnySleuthTrace1Application.class, args);
	}

}
