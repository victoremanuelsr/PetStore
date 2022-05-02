package com.victoremanuelsr.petstore.exceptions;

public class InvalidPetException extends RuntimeException {
    public InvalidPetException(String message) {
        super(message);
    }

    public InvalidPetException() {
        super("Invalid pet format.");
    }
}
