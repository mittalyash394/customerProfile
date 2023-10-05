package com.yash.customer.customerProfile.exception;

public class ConfirmPasswordNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ConfirmPasswordNullException(String message){
        super(message);
    }

}
