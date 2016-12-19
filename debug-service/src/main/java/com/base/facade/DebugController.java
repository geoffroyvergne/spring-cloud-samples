package com.base.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/debug")
public class DebugController {
    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @RequestMapping(value="/echo", produces= MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
    public ResponseEntity<Map> echo() {

        logger.info("echo");

        Map result = new HashMap<String, String>();
        result.put("message", "hello");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
