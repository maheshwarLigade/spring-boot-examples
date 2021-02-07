package com.techwasti.twiliodemo.controller;

import com.techwasti.twiliodemo.model.UserInfo;
import com.techwasti.twiliodemo.service.UserInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    public Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userService;
   
    // to get the usertoken
    @RequestMapping(value = "token", method = RequestMethod.GET)
    public ResponseEntity<UserInfo> getUserTokens(){
        UserInfo user = userService.createToken();
        return ResponseEntity.ok(user);
    }

}