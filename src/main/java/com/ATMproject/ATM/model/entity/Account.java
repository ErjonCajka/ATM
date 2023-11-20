package com.ATMproject.ATM.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "account")
@Getter@Setter
public class Account extends BaseAtm  {
    private long accountNumber;
    private double accountBalance;
    private String accountType;
    //user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id",unique = true)
    private User user;
    //card

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id",referencedColumnName = "id",unique = true)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id",unique = true)
    private Customer customer;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id",referencedColumnName = "id",unique = true)
    private Bank bank;


}