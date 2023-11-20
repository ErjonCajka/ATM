package com.ATMproject.ATM.exception;

public class AtmMachineOutOfFunction extends RuntimeException{
    public AtmMachineOutOfFunction(String mesage){
        super(mesage);
    }
}
