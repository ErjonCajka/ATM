package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
public class TransactionCreateRequest {
    private String type;
    private double amount;
    private Account account;
}
