package com.bpr.route.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @RequestMapping(value="/")
    public String root () {
        return "HELLO";
    }

}