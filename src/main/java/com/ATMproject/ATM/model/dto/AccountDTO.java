package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.entity.Card;
import com.ATMproject.ATM.model.entity.Customer;
import com.ATMproject.ATM.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private int id;
    private long accountNumber;
    private double accountBalance;
    private String accountType;
    private User user;
    private Card card;
    private Customer customer;

    public AccountDTO(Integer id, long accountNumber, double accountBalance, String accountType, User user, Card card, Customer customer) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.user = user;
        this.card = card;
        this.customer = customer;
    }
}
