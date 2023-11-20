package com.ATMproject.ATM.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
public class BankCreateRequest {
    private String name;
    private String adress;
    private long contactNumber;
}
