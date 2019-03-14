package com.example.family;

public class InvalidChildAdditionException extends RuntimeException {
    InvalidChildAdditionException(String message) {
        super(message);
    }
}
