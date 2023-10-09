package com.yash.customer.customerProfile.exception;

public class LastNameFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public LastNameFormatException(String message){
        super(message);
    }

}
