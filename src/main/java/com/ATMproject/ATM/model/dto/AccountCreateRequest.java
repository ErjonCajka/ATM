package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.entity.Bank;
import com.ATMproject.ATM.model.entity.Card;
import com.ATMproject.ATM.model.entity.Customer;
import com.ATMproject.ATM.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateRequest {
    private long accountNumber;
    private double accountBalance;
    private String accountType;
    private User user;
    private Card card;
    private Customer customer;

}
