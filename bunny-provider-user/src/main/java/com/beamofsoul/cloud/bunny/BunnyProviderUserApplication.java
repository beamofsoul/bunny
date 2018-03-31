package com.beamofsoul.cloud.bunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class BunnyProviderUserApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BunnyProviderUserApplication.class, args);
	}
}
