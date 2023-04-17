package com.epam.uni.exception;

/**
 * custom exception for not found errors
 *
 * @author bakhridinova
 */

public class CustomEntityNotFoundException extends RuntimeException {
    public CustomEntityNotFoundException(String message) {
        super(message);
    }
}
