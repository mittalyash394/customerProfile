package com.yash.customer.customerProfile.controller;

import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.entity.CustomerProfile;
import com.yash.customer.customerProfile.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public static final Logger log = LogManager.getLogger(CustomerController.class);


    @Value("${spring.application.name}")
    public String applicationName;

    @GetMapping(value = "root")
    public String root(){
        log.info("This is a customerProfile root method");
        return "This is a " + applicationName;
    }

    @PostMapping(value = "registerCustomer", headers = "Accept=application/json")
    public CustomerProfile registerCustomer(@RequestBody RegisterCustomerDto registerCustomerDto){
        log.info("Registration of customer");
        CustomerProfile customerProfile = customerService.registerCustomer(registerCustomerDto);
        log.info("The registration for the customer has been possessed");
        return customerProfile;
    }

    @GetMapping(value = "allCustomers", headers = "Accept=application/json")
    public List<CustomerProfile> getAllCustomers(){
        log.info("Getting the list for the customers");
        List<CustomerProfile> customerProfileList = customerService.getAllCustomers();
        return customerProfileList;
    }

}
