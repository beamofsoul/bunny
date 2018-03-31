package com.beamofsoul.cloud.bunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients //开启Spring Cloud Feign功能
@EnableDiscoveryClient
@SpringBootApplication
public class BunnyFeignConsumerApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BunnyFeignConsumerApplication.class, args);
	}
}
