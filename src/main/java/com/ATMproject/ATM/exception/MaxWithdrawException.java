package com.ATMproject.ATM.exception;

public class MaxWithdrawException extends  RuntimeException{
    public MaxWithdrawException(String message){
        super(message);
    }
}
