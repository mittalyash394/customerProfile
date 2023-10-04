package com.yash.customer.customerProfile.controller;

import com.yash.customer.customerProfile.dto.CustomerLoginDto;
import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.dto.UpdatePasswordDto;
import com.yash.customer.customerProfile.entity.CustomerProfile;
import com.yash.customer.customerProfile.service.CustomerService;
import com.yash.customer.customerProfile.utility.PayloadCheck;
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

    @Autowired(required = true)
    private PayloadCheck payloadCheck;

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
        CustomerProfile customerProfile = null;
        log.info("Registration of customer");
        if(!payloadCheck.isRegisterCustomerPayloadValid(registerCustomerDto)){
            throw new RuntimeException("The registerCustomerPayload is not valid");
        }
        try {
            customerProfile = customerService.registerCustomer(registerCustomerDto);
            log.info("The registration for the customer has been possessed");
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return customerProfile;
    }

    @GetMapping(value = "allCustomers", headers = "Accept=application/json")
    public List<CustomerProfile> getAllCustomers(){
        log.info("Getting the list for the customers");
        List<CustomerProfile> customerProfileList = customerService.getAllCustomers();
        if(customerProfileList.isEmpty()){
            return customerProfileList;
        }
        return customerProfileList;
    }

    @GetMapping(value = "getCustomerById/{customerId}", headers = "Accept=application/json")
    public CustomerProfile getCustomerById(@PathVariable String customerId){
        log.info("Finding the customer by the customerId");
        CustomerProfile customerProfile = null;
        if(!payloadCheck.isCustomerIdValid(customerId)){
            throw new RuntimeException("The customerId is not valid");
        }
        try {
            customerProfile = customerService.getCustomerById(customerId);
        }catch (Exception e){
            log.error(e);
            throw new RuntimeException(e.getLocalizedMessage());
        }

        return customerProfile;
    }

    @PutMapping(value = "updatePassword", headers = "Accept=application/json")
    public CustomerProfile updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        log.info("Updating the password by the emailId");
        CustomerProfile customerProfile = null;
        if(!payloadCheck.isUpdatePasswordPayloadValid(updatePasswordDto)){
            throw new RuntimeException("The updatePassword payload is not valid");
        }
        try {
            customerProfile = customerService.updatePassword(updatePasswordDto);
        }
        catch (Exception e){
            log.error(e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return customerProfile;
    }

    @DeleteMapping(value = "deleteCustomer/{customerId}", headers = "Accept=application/json")
    public boolean deleteCustomerById(@PathVariable String customerId){
        log.info("Deleting the customer by customerId");
        boolean isDeleted = false;
        if(!payloadCheck.isCustomerIdValid(customerId)){
            throw new RuntimeException("The customerId is not valid");
        }
        try {
            isDeleted = customerService.deleteCustomerById(customerId);
        }catch (Exception e){
            log.error(e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return isDeleted;
    }

    @PostMapping(value = "customerLogin", headers = "Accept=application/json")
    public CustomerProfile customerLogin(@RequestBody CustomerLoginDto customerLoginDto){
        log.info("Login into the system");
        CustomerProfile customerProfile = null;
        if(!payloadCheck.isLoginPayloadValid(customerLoginDto)){
            throw new RuntimeException("The login payload is not valid");
        }
        try {
            customerProfile = customerService.loginCustomer(customerLoginDto);
        }catch (Exception e){
            log.error(e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return customerProfile;
    }

}
