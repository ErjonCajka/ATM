package com.ATMproject.ATM.model.entity;

import jakarta.persistence.*;
//import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;

import java.util.List;

@Entity
@Table(name = "bank")
public class Bank extends BaseAtm {

    private String name;
    private String adress;
    private long contactNumber;

    @OneToMany(mappedBy = "bank")
    private List<Account> account;

    @OneToOne(mappedBy = "bank")
    private AtmMachine atmMachines;

}
