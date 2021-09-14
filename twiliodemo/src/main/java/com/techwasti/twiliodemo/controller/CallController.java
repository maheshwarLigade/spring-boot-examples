package com.techwasti.twiliodemo.controller;

import com.techwasti.twiliodemo.service.CallService;
import com.twilio.twiml.TwiMLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/call")
public class CallController {
    

    @Autowired
    CallService callService;

    @RequestMapping(value = "/voice", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> detConnectClientVoice(@RequestParam(value = "To", required = false) String to) throws TwiMLException {
        
        String xml = callService.createVoiceResponse(to);
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }

    @RequestMapping(value = "/direct-client", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getDirectClientVoice() throws TwiMLException {
        
        String xml = callService.getRedirectToClientVoiceResponse();
        return new ResponseEntity<>(xml, HttpStatus.OK);
    }
}
