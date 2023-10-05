package com.yash.customer.customerProfile.exception;

public class PasswordNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PasswordNullException(String message){
        super(message);
    }

}
