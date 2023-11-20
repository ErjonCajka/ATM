package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.dto.BaseAtmDTO;
import com.ATMproject.ATM.model.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO extends BaseAtmDTO {
    private String type;
    private double amount;
    private Account account;
    public TransactionDTO(Integer id, String type) {
        super(id);
        this.type = type;
    }
}
