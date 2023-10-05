package com.yash.customer.customerProfile.controller;

import com.yash.customer.customerProfile.entity.ErrorMessage;
import com.yash.customer.customerProfile.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    Date date = new Date();
    @ExceptionHandler(FirstNameNullException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage firstNameExceptions(FirstNameNullException firstNameNullException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                firstNameNullException.getMessage(),
                "The firstName is not correct for registration"
        );
    }

    @ExceptionHandler(LastNameNullException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage lastNameExceptions(LastNameNullException lastNameNullException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                lastNameNullException.getMessage(),
                "The lastName is not correct for registration"
        );
    }

    @ExceptionHandler(EmailIdNullException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage emailIdNullExceptions(EmailIdNullException emailIdNullException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                emailIdNullException.getMessage(),
                "The emailId is not correct"
        );
    }

    @ExceptionHandler(PasswordNullException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage passwordNullException(PasswordNullException passwordNullException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                passwordNullException.getMessage(),
                "The password is not correct"
        );
    }

    @ExceptionHandler(ConfirmPasswordNullException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage firstNameExceptions(ConfirmPasswordNullException confirmPasswordNullException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                confirmPasswordNullException.getMessage(),
                "The confirmPassword is not correct"
        );
    }

    @ExceptionHandler(ZeroBalanceException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage zeroBalanceExceptions(ZeroBalanceException zeroBalanceException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                zeroBalanceException.getMessage(),
                "The balance is not correct for registration"
        );
    }

    @ExceptionHandler(PasswordAndConfirmPasswordException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage firstNameExceptions(PasswordAndConfirmPasswordException passwordAndConfirmPasswordException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                passwordAndConfirmPasswordException.getMessage(),
                "The password and confirmPassword is not same"
        );
    }

    @ExceptionHandler(CustomerIdNullException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage customerIdNullExceptions(CustomerIdNullException customerIdNullException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                customerIdNullException.getMessage(),
                "The password and confirmPassword is not same"
        );
    }

    @ExceptionHandler(AlreadyPresentCustomerException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage alreadyCustomerExceptions(AlreadyPresentCustomerException alreadyPresentCustomerException) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                alreadyPresentCustomerException.getMessage(),
                "The customer is already present in the DB"
        );
    }

    @ExceptionHandler(NoCustomerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage noCustomerFoundExceptions(NoCustomerFoundException noCustomerFoundException) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                noCustomerFoundException.getMessage(),
                "No customer is present in the DB"
        );
    }

    @ExceptionHandler(WrongCredentialException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage wrongCredentialsFoundExceptions(WrongCredentialException wrongCredentialException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                wrongCredentialException.getMessage(),
                "The password is wrong"
        );
    }

    @ExceptionHandler(RegisterPayloadException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage RegisterPayloadExceptions(RegisterPayloadException registerPayloadException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                registerPayloadException.getMessage(),
                "The payload for registration is wrong"
        );
    }

    @ExceptionHandler(UpdatePasswordPayloadException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage updatePasswordPayloadExceptions(UpdatePasswordPayloadException updatePasswordPayloadException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                updatePasswordPayloadException.getMessage(),
                "The payload for updatePassword is wrong"
        );
    }

    @ExceptionHandler(LoginPayloadException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage loginPayloadExceptions(LoginPayloadException loginPayloadException) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date)),
                loginPayloadException.getMessage(),
                "The payload for login is wrong"
        );
    }

}
