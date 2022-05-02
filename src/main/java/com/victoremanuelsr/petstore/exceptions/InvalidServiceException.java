package com.victoremanuelsr.petstore.exceptions;

public class InvalidServiceException extends RuntimeException{
    public InvalidServiceException() {
        super("Invalid Service");
    }
    public InvalidServiceException(String message) {
        super(message);
    }
}

