package com.yash.customer.customerProfile.exception;

public class FirstNameNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FirstNameNullException(String message){
        super(message);
    }

}
