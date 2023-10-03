package com.yash.customer.customerProfile.repo;

import com.yash.customer.customerProfile.entity.CustomerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepo extends MongoRepository<CustomerProfile, String> {

    @Query("{'customerEmailId' : ?0}")
    CustomerProfile findByEmailId(String emailId);

    @Query(value="{'_id' : ?0}", delete = true)
    boolean deleteByCustomerId(String customerId);

    @Query("{'customerEmailId' : ?0 , 'customerPassword' : ?1}")
    CustomerProfile findByEmailAndPassword(String customerEmailId, String customerPassword);
}
