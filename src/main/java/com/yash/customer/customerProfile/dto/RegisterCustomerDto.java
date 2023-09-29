package com.yash.customer.customerProfile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerDto {

    private String customerFirstName;
    private String customerLastName;
    private String customerEmailId;
    private String customerPassword;
    private String customerConfirmPassword;
    private String customerBalance;

}
