package com.victoremanuelsr.petstore.test.exceptions;

import com.victoremanuelsr.petstore.exceptions.InvalidPetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidPetExceptionTest {
    @Test
    public void newPetExceptionTest(){
        InvalidPetException exception = Assertions.assertThrows(InvalidPetException.class, () -> {
            throw new InvalidPetException();
        });
        Assertions.assertEquals("Invalid pet format.", exception.getMessage());
    }
}
