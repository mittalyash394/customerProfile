package com.yash.customer.customerProfile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CustomerProfile {

    @Id
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmailId;
    private String customerPassword;
    private String customerConfirmPassword;
    private String customerBalance;
    private String createdAt;
    private String updatedAt;


}
