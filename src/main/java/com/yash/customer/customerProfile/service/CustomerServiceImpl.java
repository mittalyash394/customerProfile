package com.yash.customer.customerProfile.service;

import com.yash.customer.customerProfile.dto.CustomerLoginDto;
import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.dto.UpdatePasswordDto;
import com.yash.customer.customerProfile.entity.CustomerProfile;
import com.yash.customer.customerProfile.repo.CustomerRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    public static final Logger log = LogManager.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerProfile registerCustomer(RegisterCustomerDto registerCustomerDto) {
        log.info("The registration for the customer has been started");
        Date date = new Date();
        CustomerProfile customerProfileFromDB = customerRepo.findByEmailId(registerCustomerDto.getCustomerEmailId());
        if(customerProfileFromDB != null){
            throw new RuntimeException("The customer is already present with this emaildId");
        }
        else {
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
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        log.info("Getting the list for the customers");
        List<CustomerProfile> customerProfiles = customerRepo.findAll();
        log.info("The list for the customers has been printed");
        return customerProfiles;
    }

    @Override
    public CustomerProfile getCustomerById(String customerId) {
        log.info("Getting the customer details from the DB");
        Optional<CustomerProfile> customerProfile = customerRepo.findById(customerId);
        if(customerProfile.get() == null){
            throw new RuntimeException("No customer found with this customerId");
        }
        return customerProfile.get();
    }

    @Override
    public CustomerProfile updatePassword(UpdatePasswordDto updatePasswordDto) {
        log.info("Updating the customer password in database");
        CustomerProfile customerProfileFromDB = customerRepo.findByEmailId(updatePasswordDto.getEmailId());
        if(customerProfileFromDB==null){
            throw new RuntimeException("No customer found for this emailId");
        }
        String customerId = customerProfileFromDB.getCustomerId();
        Date date = new Date();
        Optional<CustomerProfile> customerProfileByUserId = customerRepo.findById(customerId);
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerId(customerId);
        customerProfile.setCustomerFirstName(customerProfileFromDB.getCustomerFirstName());
        customerProfile.setCustomerLastName(customerProfile.getCustomerLastName());
        customerProfile.setCustomerEmailId(customerProfileFromDB.getCustomerEmailId());
        customerProfile.setCustomerPassword(updatePasswordDto.getUpdatePassword());
        customerProfile.setCustomerConfirmPassword(updatePasswordDto.getUpdateConfirmPassword());
        customerProfile.setCustomerBalance(customerProfileFromDB.getCustomerBalance());
        customerProfile.setCreatedAt(customerProfileFromDB.getCreatedAt());
        customerProfile.setUpdatedAt(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date));
        customerRepo.save(customerProfile);
        return customerProfile;
    }

    @Override
    public boolean deleteCustomerById(String customerId) {
        log.info("Deleting the customer by ID");
        Optional<CustomerProfile> customerProfileFromDB = customerRepo.findById(customerId);
        if(customerProfileFromDB.isEmpty()){
            throw new RuntimeException("No customer found for the customerId");
        }
        boolean isDeleted = customerRepo.deleteByCustomerId(customerId);
        return isDeleted;
    }

    @Override
    public CustomerProfile loginCustomer(CustomerLoginDto customerLoginDto) {
        CustomerProfile customerProfileFromDB = customerRepo.findByEmailId(customerLoginDto.getCustomerEmailId());
        if(customerProfileFromDB == null){
            throw new RuntimeException("No customer found for the given emailId");
        }
        CustomerProfile customerProfile = customerRepo.findByEmailAndPassword(customerLoginDto.getCustomerEmailId(), customerLoginDto.getCustomerPassword());
        if(customerProfile == null){
            throw new RuntimeException("The password is wrong for the emailId");
        }
        return customerProfile;
    }
}
