package com.yash.customer.customerProfile.exception;

public class PasswordFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PasswordFormatException(String message){
        super(message);
    }

}
