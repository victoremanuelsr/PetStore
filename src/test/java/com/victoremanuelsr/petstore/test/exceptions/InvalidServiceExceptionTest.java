package com.victoremanuelsr.petstore.test.exceptions;

import com.victoremanuelsr.petstore.exceptions.InvalidServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidServiceExceptionTest {
    @Test
    public void newInvalidServiceTest(){
        InvalidServiceException exception = Assertions.assertThrows(InvalidServiceException.class, () -> {
           throw new InvalidServiceException();
        });
        Assertions.assertEquals("Invalid Service", exception.getMessage());
    }
}
