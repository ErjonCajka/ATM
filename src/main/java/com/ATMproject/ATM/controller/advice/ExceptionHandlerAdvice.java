package com.ATMproject.ATM.controller.advice;

import com.ATMproject.ATM.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> handleResourceNotFoundException(ResourceNotFoundException exp,
                                                                            HttpServletRequest req){
        var response = new ExceptionMessage(HttpStatus.NOT_FOUND.value(), req.getRequestURI(), exp.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> handleResourceNotFoundException(InsufficientBalanceException exp,
                                                                           HttpServletRequest req){
        var response = new ExceptionMessage(HttpStatus.NOT_FOUND.value(), req.getRequestURI(), exp.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> atmStatusHandler(AtmMachineOutOfFunction exp,
                                                                           HttpServletRequest req){
        var response = new ExceptionMessage(HttpStatus.NOT_FOUND.value(), req.getRequestURI(), exp.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> maxWithdrawException(MaxWithdrawException exp,
                                                             HttpServletRequest req){
        var response = new ExceptionMessage(HttpStatus.NOT_FOUND.value(), req.getRequestURI(), exp.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }


}
