package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.entity.Bank;

public class AtmMachineDTO extends BaseAtmDTO {
    private String location;
    private boolean status; //on/off
    private double atmAmount;
    private Bank bank;
}
