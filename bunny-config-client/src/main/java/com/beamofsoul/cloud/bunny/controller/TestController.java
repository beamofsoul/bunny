package com.beamofsoul.cloud.bunny.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // 更新配置不用重启服务器
@RestController
public class TestController {

	@Value("${from}")
	private String from;
	
	@GetMapping("/from")
	public String from() {
		return this.from;
	}
	
//	@Autowired
//	private Environment env;
//	
//	@GetMapping("/from")
//	public String from() {
//		return env.getProperty("from", "undefined");
//	}
}
