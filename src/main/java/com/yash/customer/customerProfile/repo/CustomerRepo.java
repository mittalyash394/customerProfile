package com.yash.customer.customerProfile.repo;

import com.yash.customer.customerProfile.entity.CustomerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<CustomerProfile, String> {
}
