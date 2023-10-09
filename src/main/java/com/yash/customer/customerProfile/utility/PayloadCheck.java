package com.yash.customer.customerProfile.utility;

import com.yash.customer.customerProfile.dto.CustomerLoginDto;
import com.yash.customer.customerProfile.dto.RegisterCustomerDto;
import com.yash.customer.customerProfile.dto.UpdatePasswordDto;
import com.yash.customer.customerProfile.exception.*;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PayloadCheck {
    public boolean isRegisterCustomerPayloadValid(RegisterCustomerDto registerCustomerDto) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        String nameRegex= "[A-Z][a-z]*";

        if(registerCustomerDto.getCustomerFirstName()==null || registerCustomerDto.getCustomerFirstName().isEmpty()){
            throw new FirstNameNullException("The firstName cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerLastName()==null || registerCustomerDto.getCustomerLastName().isEmpty()){
            throw new LastNameNullException("The lastName cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerEmailId()==null || registerCustomerDto.getCustomerEmailId().isEmpty()){
            throw new EmailIdNullException("The emailId cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerPassword()==null || registerCustomerDto.getCustomerPassword().isEmpty()){
            throw new PasswordNullException("The customerPassword cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerConfirmPassword()==null || registerCustomerDto.getCustomerConfirmPassword().isEmpty()){
            throw new ConfirmPasswordNullException("The customer confirmPassword cannot be null or empty");
        }
        if(registerCustomerDto.getCustomerBalance() <= 0){
            throw new ZeroBalanceException("The customerBalance cannot be less than 0 or equal to 0");
        }
        if(!registerCustomerDto.getCustomerPassword().equals(registerCustomerDto.getCustomerConfirmPassword())){
            throw new PasswordAndConfirmPasswordException("The password and confirmPassword should be same");
        }

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailPattern.matcher(registerCustomerDto.getCustomerEmailId());
        if(!emailPatternMatcher.matches()){
            throw new EmailIdFormatException("The emailId format is not matched");
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordPatternMatcher = passwordPattern.matcher(registerCustomerDto.getCustomerPassword());
        if(!passwordPatternMatcher.matches()){
            throw new PasswordFormatException("The password format is not matched");
        }

        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher firstNamePatternMatcher = namePattern.matcher(registerCustomerDto.getCustomerFirstName());
        if(!firstNamePatternMatcher.matches()){
            throw new FirstNameFormatException("The firstName format is not matched");
        }

        Matcher lastNamePatternMatcher = namePattern.matcher(registerCustomerDto.getCustomerLastName());
        if(!lastNamePatternMatcher.matches()){
            throw new LastNameFormatException("The lastName format is not matched");
        }
        return true;
    }

    public boolean isCustomerIdValid(String customerId) {
        if(customerId == null || customerId.isEmpty()){
            throw new CustomerIdNullException("The customerId cannot be null or empty");
        }
        return true;
    }

    public boolean isUpdatePasswordPayloadValid(UpdatePasswordDto updatePasswordDto) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        if(updatePasswordDto.getEmailId()==null || updatePasswordDto.getEmailId().isEmpty()){
            throw new EmailIdNullException("The emailId cannot be null or empty");
        }
        if(updatePasswordDto.getUpdatePassword()==null || updatePasswordDto.getUpdatePassword().isEmpty()){
            throw new PasswordNullException("The customerPassword cannot be null or empty");
        }
        if(updatePasswordDto.getUpdateConfirmPassword()==null || updatePasswordDto.getUpdateConfirmPassword().isEmpty()){
            throw new ConfirmPasswordNullException("The customer confirmPassword cannot be null or empty");
        }
        if(!updatePasswordDto.getUpdatePassword().equals(updatePasswordDto.getUpdateConfirmPassword())){
            throw new PasswordAndConfirmPasswordException("The password and confirmPassword should be same");
        }
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailPattern.matcher(updatePasswordDto.getEmailId());
        if(!emailPatternMatcher.matches()){
            throw new EmailIdFormatException("The emailId format is not matched");
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordPatternMatcher = passwordPattern.matcher(updatePasswordDto.getUpdatePassword());
        if(!passwordPatternMatcher.matches()){
            throw new PasswordFormatException("The password format is not matched");
        }

        Matcher confirmPasswordPattern = passwordPattern.matcher(updatePasswordDto.getUpdateConfirmPassword());
        if(!confirmPasswordPattern.matches()){
            throw new ConfirmPasswordFormatException("The confirm password format is not matched");
        }
        return true;
    }

    public boolean isLoginPayloadValid(CustomerLoginDto customerLoginDto) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        if(customerLoginDto.getCustomerEmailId()==null || customerLoginDto.getCustomerEmailId().isEmpty()){
            throw new EmailIdNullException("The emailId cannot be null or empty");
        }
        if(customerLoginDto.getCustomerPassword()==null || customerLoginDto.getCustomerPassword().isEmpty()){
            throw new PasswordNullException("The customerPassword cannot be null or empty");
        }
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailPattern.matcher(customerLoginDto.getCustomerEmailId());
        if(!emailPatternMatcher.matches()){
            throw new EmailIdFormatException("The emailId format is not matched");
        }
        return true;
    }
}
