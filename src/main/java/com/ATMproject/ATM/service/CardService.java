package com.ATMproject.ATM.service;

import com.ATMproject.ATM.model.dto.CardDTO;

public interface CardService {
    CardDTO findById(Integer id);

}
