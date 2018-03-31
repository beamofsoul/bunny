package com.beamofsoul.cloud.bunny;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker // 开启断路器功能
//@EnableDiscoveryClient // 开启服务发现功能
//@SpringBootApplication
@SpringCloudApplication // 包含以上三个注解
public class BunnyRibbonConsumerApplication {
	
    public static void main( String[] args ) {
        SpringApplication.run(BunnyRibbonConsumerApplication.class, args);
    }
    
    @Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
