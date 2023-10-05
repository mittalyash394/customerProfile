package com.yash.customer.customerProfile.exception;

public class LoginPayloadException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public LoginPayloadException(String message){
        super(message);
    }

}
