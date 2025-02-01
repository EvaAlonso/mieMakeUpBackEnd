package com.OnceFactoriaF5.miemakeup.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException exception){
        int errorsNumber = exception.getBindingResult().getErrorCount();
        List<String> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error)->errors.add(error.getDefaultMessage()));
        ErrorResponse errorResponse = new ErrorResponse(
                errors,
                errorsNumber
        );

        return new ResponseEntity<>(new ErrorResponse(errors, errorsNumber), HttpStatus.BAD_REQUEST);
    }
}
