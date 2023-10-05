package com.yash.customer.customerProfile.exception;

public class PasswordAndConfirmPasswordException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PasswordAndConfirmPasswordException(String message){
        super(message);
    }

}
