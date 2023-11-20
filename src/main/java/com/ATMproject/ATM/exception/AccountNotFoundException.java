package com.ATMproject.ATM.exception;

public class AccountNotFoundException extends RuntimeException{

    AccountNotFoundException(String message){
        super(message);
    }
}
