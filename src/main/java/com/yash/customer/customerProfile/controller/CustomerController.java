package com.yash.customer.customerProfile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Value("${spring.application.name}")
    public String applicationName;

    @GetMapping(value = "root")
    public String root(){
        return "This is a " + applicationName;
    }

}
