package com.dbs.movie_ticket_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @Value("${welcome.message}")
//    private String welcomeMessage = "Hey welcome stranger";
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String helloWorld(){
//        return welcomeMessage;
//    }

//    @GetMapping("/customer/home")
//    public String home(){
//        return "this is customer page";
//    }
    @GetMapping("/admin/home")
    public String admin(){
        return "this is admin page";
    }

}
