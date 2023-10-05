package com.yash.customer.customerProfile.exception;

public class AlreadyPresentCustomerException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AlreadyPresentCustomerException(String message){
        super(message);
    }
}
