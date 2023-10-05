package com.yash.customer.customerProfile.exception;

public class LastNameNullException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public LastNameNullException(String message){
        super(message);
    }

}
