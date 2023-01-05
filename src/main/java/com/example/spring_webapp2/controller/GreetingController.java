package com.example.spring_webapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("hello")
    public String index2(){
        return "index2";
    }


}
