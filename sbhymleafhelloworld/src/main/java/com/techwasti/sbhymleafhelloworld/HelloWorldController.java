package com.techwasti.sbhymleafhelloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    
    // this message we are reading from application.properties file

    @Value("${hello.message}")
    private String message;


    @GetMapping("/")
    public String hellomessage(Model model) {
        model.addAttribute("message", message);

        return "helloworld"; //view  
    }

     // pass some parameter like /hello?name=thymeleaf
    @GetMapping("/hello")
    public String helloWithParam(
            @RequestParam(name = "name", required = true, defaultValue = "springboot") 
            String name, Model model) {

        model.addAttribute("message", name);

        return "helloworld"; //view
    }

}
