package com.base.facade;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class EchoController {
    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

    @RequestMapping(value="/echo", produces= MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
    public ResponseEntity<Map> echo(HttpServletRequest request) {
        logger.info("echo");

        Map result = new HashMap<String, String>();
        result.put("echo", "hello");
        result.put("localAddr", request.getLocalAddr());
        result.put("localPort", request.getLocalPort());
        result.put("hostName", getHostName());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private String getHostName() {
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return addr.getHostName();
    }
}
