package com.beamofsoul.cloud.bunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BunnyEurekaServerApplication 
{
    public static void main(String[] args) {
    	SpringApplication.run(BunnyEurekaServerApplication.class, args);
	}
}
