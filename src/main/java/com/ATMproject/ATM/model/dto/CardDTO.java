package com.ATMproject.ATM.model.dto;

import com.ATMproject.ATM.model.dto.AccountDTO;
import com.ATMproject.ATM.model.dto.BaseAtmDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CardDTO extends BaseAtmDTO {
    private long cardNumber;

    public CardDTO(Integer id, long cardNumber, LocalDateTime expire, String cardType) {
        super(id);
        this.cardNumber = cardNumber;
        this.expire = expire;
        this.cardType = cardType;
    }

    private LocalDateTime expire;
    private String cardType;
    private AccountDTO account;
    public CardDTO(){

    }

}
