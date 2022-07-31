package com.teechwasti.sbactuatorlogrestapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
  
    private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

    @GetMapping("/hello")
    public ResponseEntity<String> logDetails() {
        LOGGER.info("Demo log message. Logged at: " + new Date().toString());
        return ResponseEntity.ok("Message Logged");
    }
}
