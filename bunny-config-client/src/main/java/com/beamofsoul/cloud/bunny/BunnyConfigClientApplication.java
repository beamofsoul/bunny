package com.beamofsoul.cloud.bunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BunnyConfigClientApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BunnyConfigClientApplication.class, args);
	}
}
