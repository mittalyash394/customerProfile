package com.yash.customer.customerProfile.exception;

public class FirstNameFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FirstNameFormatException(String message){
        super(message);
    }

}
