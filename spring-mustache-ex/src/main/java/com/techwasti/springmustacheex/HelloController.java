package com.techwasti.springmustacheex;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping(value = {"/", "/hello"})
    public String greetMessage(Model model) {

        String helloworld="Hello and welcome to mustache";

        model.addAttribute("message", helloworld);

        return "hello";
    }
    // this is we have added to demonstrate the @RequestParam annotation.
    @RequestMapping(path="/greeting", produces=MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String greetUser(@RequestParam(defaultValue="GuestUser") String name,
                              @RequestParam(required = false) String adult) {

        var greet = "on".equals(adult) ? "Good morning" : "Hi";

        return String.format("%s %s!", greet, name);
    }
}
