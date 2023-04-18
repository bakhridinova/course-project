package com.epam.uni.exception;

/**
 * custom exception for validation errors
 *
 * @author bakhridinova
 */

public class CustomIValidationException extends RuntimeException {
    public CustomIValidationException(String message) {
        super(message);
    }
}
