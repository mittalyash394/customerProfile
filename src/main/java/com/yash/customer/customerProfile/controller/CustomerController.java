package com.yash.customer.customerProfile.controller;

import com.yash.customer.customerProfile.dto.CustomerLoginDto;
import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.dto.UpdatePasswordDto;
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

    @GetMapping(value = "getCustomerById/{customerId}", headers = "Accept=application/json")
    public CustomerProfile getCustomerById(@PathVariable String customerId){
        log.info("Finding the customer by the customerId");
        CustomerProfile customerProfile = customerService.getCustomerById(customerId);
        return customerProfile;
    }

    @PutMapping(value = "updatePassword", headers = "Accept=application/json")
    public CustomerProfile updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        log.info("Updating the password by the emailId");
        CustomerProfile customerProfile = customerService.updatePassword(updatePasswordDto);
        return customerProfile;
    }

    @DeleteMapping(value = "deleteCustomer/{customerId}", headers = "Accept=application/json")
    public boolean deleteCustomerById(@PathVariable String customerId){
        log.info("Deleting the customer by customerId");
        boolean isDeleted = customerService.deleteCustomerById(customerId);
        return isDeleted;
    }

    @PostMapping(value = "customerLogin", headers = "Accept=application/json")
    public CustomerProfile customerLogin(@RequestBody CustomerLoginDto customerLoginDto){
        log.info("Login into the system");
        CustomerProfile customerProfile = customerService.loginCustomer(customerLoginDto);
        return customerProfile;
    }

}
