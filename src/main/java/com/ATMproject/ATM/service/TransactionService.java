package com.ATMproject.ATM.service;

import com.ATMproject.ATM.model.dto.TransactionCreateRequest;
import com.ATMproject.ATM.model.dto.TransactionDTO;
import com.ATMproject.ATM.model.entity.Transaction;

import java.util.Optional;

public interface TransactionService {
    TransactionDTO deposit(TransactionCreateRequest createRequest);
    TransactionDTO withdraw(TransactionCreateRequest createRequest);
    TransactionDTO transfer(TransactionCreateRequest createRequest,Integer accountIdReciever);
    TransactionDTO findById(Integer id);
    TransactionDTO save(TransactionCreateRequest transactionCreateRequest);
}
