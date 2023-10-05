package com.yash.customer.customerProfile.exception;

public class UpdatePasswordPayloadException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UpdatePasswordPayloadException(String message){
        super(message);
    }

}
