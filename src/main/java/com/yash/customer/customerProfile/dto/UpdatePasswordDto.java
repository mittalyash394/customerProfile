package com.yash.customer.customerProfile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordDto {

    private String emailId;
    private String updatePassword;
    private String updateConfirmPassword;

}
