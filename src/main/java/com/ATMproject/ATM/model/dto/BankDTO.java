package com.ATMproject.ATM.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO extends BaseAtmDTO {
    private String name;
    private String adress;
    private long contactNumber;
}
