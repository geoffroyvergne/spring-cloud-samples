package com.base.facade;

import com.base.client.DebugClient;
import com.base.service.DebugService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/debug")
public class DebugController {

    @Autowired
    DebugService debugService;

    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @RequestMapping(value="/echo", produces= MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
    public ResponseEntity<Map> echo() {

        logger.info("echo");

        Map result = debugService.getEcho();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
