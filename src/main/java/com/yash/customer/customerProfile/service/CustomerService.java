package com.yash.customer.customerProfile.service;

import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.entity.CustomerProfile;

public interface CustomerService {
    CustomerProfile registerCustomer(RegisterCustomerDto registerCustomerDto);
}
