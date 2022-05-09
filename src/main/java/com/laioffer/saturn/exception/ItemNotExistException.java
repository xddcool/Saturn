package com.laioffer.saturn.exception;



//we should throw a UserNotExist exception when the given user credential is invalid.
public class ItemNotExistException extends RuntimeException {
    public ItemNotExistException(String message) {
        super(message);
    }
}