package com.yash.customer.customerProfile.utility;

import com.yash.customer.customerProfile.dto.CustomerLoginDto;
import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.dto.UpdatePasswordDto;
import org.springframework.stereotype.Component;

@Component
public class PayloadCheck {
    public boolean isRegisterCustomerPayloadValid(RegisterCustomerDto registerCustomerDto) {
        if(registerCustomerDto.getCustomerFirstName()==null || registerCustomerDto.getCustomerFirstName().isEmpty()){
            throw new RuntimeException("The firstName cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerLastName()==null || registerCustomerDto.getCustomerLastName().isEmpty()){
            throw new RuntimeException("The lastName cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerEmailId()==null || registerCustomerDto.getCustomerEmailId().isEmpty()){
            throw new RuntimeException("The emailId cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerPassword()==null || registerCustomerDto.getCustomerPassword().isEmpty()){
            throw new RuntimeException("The customerPassword cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerConfirmPassword()==null || registerCustomerDto.getCustomerConfirmPassword().isEmpty()){
            throw new RuntimeException("The customer confirmPassword cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerBalance() <= 0){
            throw new RuntimeException("The customerBalance cannot be less than 0 or equal to 0");
        }
        if(!registerCustomerDto.getCustomerPassword().equals(registerCustomerDto.getCustomerConfirmPassword())){
            throw new RuntimeException("The password and confirmPassword should be same");
        }
        return true;
    }

    public boolean isCustomerIdValid(String customerId) {
        if(customerId == null || customerId.isEmpty()){
            throw new RuntimeException("The customerId cannot be null or empty");
        }
        return true;
    }

    public boolean isUpdatePasswordPayloadValid(UpdatePasswordDto updatePasswordDto) {
        if(updatePasswordDto.getEmailId()==null || updatePasswordDto.getEmailId().isEmpty()){
            throw new RuntimeException("The emailId cannot be null or empty");
        }
        if(updatePasswordDto.getUpdatePassword()==null || updatePasswordDto.getUpdatePassword().isEmpty()){
            throw new RuntimeException("The customerPassword cannot be null or empty");
        }
        if(updatePasswordDto.getUpdateConfirmPassword()==null || updatePasswordDto.getUpdateConfirmPassword().isEmpty()){
            throw new RuntimeException("The customer confirmPassword cannot be null or empty");
        }
        if(!updatePasswordDto.getUpdatePassword().equals(updatePasswordDto.getUpdateConfirmPassword())){
            throw new RuntimeException("The password and confirmPassword should be same");
        }
        return true;
    }

    public boolean isLoginPayloadValid(CustomerLoginDto customerLoginDto) {
        if(customerLoginDto.getCustomerEmailId()==null || customerLoginDto.getCustomerEmailId().isEmpty()){
            throw new RuntimeException("The emailId cannot be null or empty");
        }
        if(customerLoginDto.getCustomerPassword()==null || customerLoginDto.getCustomerPassword().isEmpty()){
            throw new RuntimeException("The customerPassword cannot be null or empty");
        }
        return true;
    }
}
