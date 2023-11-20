package com.ATMproject.ATM.service.impl;

import com.ATMproject.ATM.model.dto.CardDTO;
import com.ATMproject.ATM.exception.ResourceNotFoundException;
import com.ATMproject.ATM.mapper.CardMapper;
import com.ATMproject.ATM.service.CardService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Qualifier("cardServiceDB")
public class CardServiceImpl implements CardService {

    @Override
    public CardDTO findById(Integer id) {
        return null;
    }
}

