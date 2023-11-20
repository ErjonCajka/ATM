package com.ATMproject.ATM.mapper;

import com.ATMproject.ATM.model.dto.TransactionCreateRequest;
import com.ATMproject.ATM.model.dto.TransactionDTO;
import com.ATMproject.ATM.model.entity.Transaction;

public class TransactionMapper {

    public static TransactionDTO toDTO(Transaction transaction){
        TransactionDTO toReturn = new TransactionDTO();
        toReturn.setId(transaction.getId());
        toReturn.setType(transaction.getType());
        toReturn.setAmount(transaction.getAmount());
        toReturn.setAccount(transaction.getAccount());

        return toReturn;

    }
    public static Transaction toTransaction(TransactionCreateRequest transaction){
        Transaction toReturn = new Transaction();
        toReturn.setType(transaction.getType());
        toReturn.setAmount(transaction.getAmount());
        toReturn.setAccount(transaction.getAccount());

        return toReturn;

    }
}
