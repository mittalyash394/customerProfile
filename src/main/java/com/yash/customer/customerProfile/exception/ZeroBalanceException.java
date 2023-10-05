package com.yash.customer.customerProfile.exception;

public class ZeroBalanceException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ZeroBalanceException(String message){
        super(message);
    }

}
