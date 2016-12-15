package com.base.service;

import com.base.client.DebugClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DebugService {
    @Autowired
    DebugClient debugClient;

    @HystrixCommand(fallbackMethod = "getEchoReliable")
    public Map getEcho() {
        return debugClient.getEcho();
    }

    public Map getEchoReliable() {
        Map result = new HashMap<String, String>();
        result.put("message", "echo not aviable");

        return result;
    }
}
