package com.beamofsoul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

import com.beamofsoul.cloud.filter.AccessFilter;

@EnableZuulProxy //包含@EnableCircuitBreaker 和  @EnableDiscoveryClient
@SpringCloudApplication
public class BunnyAPIGatewayApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BunnyAPIGatewayApplication.class, args);
	}
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
	/**
	 * 自定义服务路由映射规则，使得默认路由规则/user-service-v1/**变为/v1/user-service
	 */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)",
				"${version}/${name}");
	}
}
