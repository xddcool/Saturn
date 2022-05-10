package com.laioffer.saturn.controller;

import com.laioffer.saturn.exception.InvalidSearchPriceException;
import com.laioffer.saturn.exception.ItemNotExistException;
import com.laioffer.saturn.exception.UserAlreadyExistException;
import com.laioffer.saturn.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public final ResponseEntity<String> handleUserAlreadyExistExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotExistException.class)
    public final ResponseEntity<String> handleUserNotExistExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ItemNotExistException.class)
    public final ResponseEntity<String> handleReservationNotFoundExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidSearchPriceException.class)
    public final ResponseEntity<String> handleInvalidSearchPriceException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

