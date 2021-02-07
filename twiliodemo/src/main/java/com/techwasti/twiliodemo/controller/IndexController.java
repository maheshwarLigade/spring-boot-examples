package com.techwasti.twiliodemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping(value = "/index")
    public ModelAndView indexPage(){
        
        return new ModelAndView("index");
    }
    
}
