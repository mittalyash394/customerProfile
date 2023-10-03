package com.yash.customer.customerProfile.service;

import com.yash.customer.customerProfile.dto.CustomerLoginDto;
import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.dto.UpdatePasswordDto;
import com.yash.customer.customerProfile.entity.CustomerProfile;

import java.util.List;

public interface CustomerService {
    CustomerProfile registerCustomer(RegisterCustomerDto registerCustomerDto);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile getCustomerById(String customerId);

    CustomerProfile updatePassword(UpdatePasswordDto updatePasswordDto);

    boolean deleteCustomerById(String customerId);

    CustomerProfile loginCustomer(CustomerLoginDto customerLoginDto);
}
