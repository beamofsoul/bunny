package com.beamofsoul.cloud.bunny.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "PROVIDER-USER")
public interface RefactorUserService extends APIUserService {

}
