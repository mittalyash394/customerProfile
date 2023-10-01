package com.yash.customer.customerProfile.service;

import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.entity.CustomerProfile;
import com.yash.customer.customerProfile.repo.CustomerRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    public static final Logger log = LogManager.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerProfile registerCustomer(RegisterCustomerDto registerCustomerDto) {
        log.info("The registration for the customer has been started");
        Date date = new Date();
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerFirstName(registerCustomerDto.getCustomerFirstName());
        customerProfile.setCustomerLastName(registerCustomerDto.getCustomerLastName());
        customerProfile.setCustomerEmailId(registerCustomerDto.getCustomerEmailId());
        customerProfile.setCustomerPassword(registerCustomerDto.getCustomerPassword());
        customerProfile.setCustomerConfirmPassword(registerCustomerDto.getCustomerConfirmPassword());
        customerProfile.setCustomerBalance(registerCustomerDto.getCustomerBalance());
        customerProfile.setCreatedAt(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date));
        customerRepo.save(customerProfile);
        log.info("The registration has been done");
        return customerProfile;
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        log.info("Getting the list for the customers");
        List<CustomerProfile> customerProfiles = customerRepo.findAll();
        log.info("The list for the customers has been printed");
        return customerProfiles;
    }
}
