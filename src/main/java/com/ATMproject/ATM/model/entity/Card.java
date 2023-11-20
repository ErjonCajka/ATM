package com.ATMproject.ATM.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "card")
public class Card extends BaseAtm {

    private long cardNumber;
    private LocalDateTime expire;
    private String cardType;

    @OneToOne(mappedBy = "card")
    private Account account;

}
