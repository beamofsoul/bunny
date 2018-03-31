package com.beamofsoul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class BunnySleuthTrace2Application {
	
	@GetMapping("/trace-2")
	public String trace() {
		log.info("=== call trace-2 ===");
		return "Trace";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BunnySleuthTrace2Application.class, args);
	}

}
