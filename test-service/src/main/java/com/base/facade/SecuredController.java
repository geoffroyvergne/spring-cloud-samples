package com.base.facade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/secured")
public class SecuredController {
    @RequestMapping("/test")
    public ResponseEntity<Map> securedCall() {

        Map result = new HashMap<String, String>();
        result.put("id", UUID.randomUUID().toString().toUpperCase());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
