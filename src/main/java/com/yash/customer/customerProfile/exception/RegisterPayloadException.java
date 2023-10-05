package com.yash.customer.customerProfile.exception;

public class RegisterPayloadException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RegisterPayloadException(String message){
        super(message);
    }

}
