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
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value="/test", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public ResponseEntity<Map> test() {

        logger.info("index");

        Map result = new HashMap<String, String>();
        result.put("code", "0");
        result.put("message", "index");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/host", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public ResponseEntity<Map> host(HttpServletRequest request) {
        logger.info("host");

        Map result = new HashMap<String, String>();
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