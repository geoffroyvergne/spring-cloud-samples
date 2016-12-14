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
}