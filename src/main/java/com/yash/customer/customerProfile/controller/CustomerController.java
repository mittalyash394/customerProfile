package com.yash.customer.customerProfile.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public static final Logger log = LogManager.getLogger(CustomerController.class);


    @Value("${spring.application.name}")
    public String applicationName;

    @GetMapping(value = "root")
    public String root(){
        log.info("This is a customerProfile root method");
        return "This is a " + applicationName;
    }

}
