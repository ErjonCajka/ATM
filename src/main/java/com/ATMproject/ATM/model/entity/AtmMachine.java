package com.ATMproject.ATM.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity@Data
@Table(name = "atmMachine")
public class AtmMachine extends BaseAtm {

    private String location;
    private boolean status; //on/off
    private double atmAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id",referencedColumnName = "id",unique = true)
    private Bank bank;


   }
