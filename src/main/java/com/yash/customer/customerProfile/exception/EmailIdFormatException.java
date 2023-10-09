package com.yash.customer.customerProfile.exception;

public class EmailIdFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmailIdFormatException(String message){
        super(message);
    }

}
