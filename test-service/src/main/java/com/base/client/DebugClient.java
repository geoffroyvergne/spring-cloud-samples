package com.base.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "debug-service")
public interface DebugClient {

    @RequestMapping(method = RequestMethod.GET, value = "/debug/echo")
    Map getEcho();

}
