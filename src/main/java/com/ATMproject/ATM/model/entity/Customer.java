package com.ATMproject.ATM.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer extends BaseAtm {

    private String name;
    private String adress;
    private int phoneNumber;
    private String personalNumber;

    @OneToMany(mappedBy = "customer")
    private List<Account> account;

}
