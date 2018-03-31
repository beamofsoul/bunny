package com.beamofsoul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

//@EnableZipkinServer
@EnableZipkinStreamServer
@SpringBootApplication
public class BunnyZipkinServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BunnyZipkinServerApplication.class, args);
	}
}
