package com.ATMproject.ATM.model.entity;

import com.ATMproject.ATM.model.dto.AccountDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity@Data
@Table(name = "transaction")
public class Transaction extends BaseAtm {
    private String type; //deposit,withdraw
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    public Transaction(String type, double amount) {
        super();
        this.type = type;
        this.amount = amount;

    }

    public Transaction() {

    }

    public Transaction(String type, double amount, Account account) {
        this.type = type;
        this.amount = amount;
        this.account = account;
    }


}
