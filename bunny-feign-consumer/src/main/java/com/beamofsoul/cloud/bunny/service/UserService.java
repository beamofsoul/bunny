package com.beamofsoul.cloud.bunny.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PROVIDER-USER") // 通过指定服务名称来绑定服务，服务名称不区分大小写
public interface UserService {

	@GetMapping("/provider") // 依赖服务中需要访问的具体服务方法
	String provider(@RequestParam("name") String name);
}
