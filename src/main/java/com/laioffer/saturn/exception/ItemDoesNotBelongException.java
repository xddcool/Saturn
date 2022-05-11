package com.laioffer.saturn.exception;


public class ItemDoesNotBelongException extends RuntimeException {
    public ItemDoesNotBelongException(String message) {
        super(message);
    }
}