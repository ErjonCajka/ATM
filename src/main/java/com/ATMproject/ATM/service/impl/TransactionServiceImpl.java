package com.ATMproject.ATM.service.impl;

import com.ATMproject.ATM.aspect.*;
import com.ATMproject.ATM.model.dto.AccountDTO;
import com.ATMproject.ATM.model.dto.TransactionCreateRequest;
import com.ATMproject.ATM.model.dto.TransactionDTO;
import com.ATMproject.ATM.model.entity.Transaction;
import com.ATMproject.ATM.repository.AccountRepository;
import com.ATMproject.ATM.repository.TransactionRepository;
import com.ATMproject.ATM.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.ATMproject.ATM.helpers.Constant.TRANSACTION_STATUS.*;
import static com.ATMproject.ATM.mapper.AccountMapper.toAccount;
import static com.ATMproject.ATM.mapper.AccountMapper.toDto;
import static com.ATMproject.ATM.mapper.TransactionMapper.toDTO;
import static com.ATMproject.ATM.mapper.TransactionMapper.toTransaction;
import static com.ATMproject.ATM.model.entity.DataInMemory.atmValues;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {


    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    TransactionServiceImpl(TransactionRepository theRepository,AccountRepository theAccount){
        transactionRepository = theRepository;
        accountRepository=theAccount;
    }


    @AtmStatus
    @Override
    public TransactionDTO deposit(TransactionCreateRequest createRequest) {
        AccountDTO accountDTO = toDto(accountRepository.findById(createRequest.getAccount().getId()));
        double balance = accountDTO.getAccountBalance() + createRequest.getAmount();
        accountDTO.setAccountBalance(balance);
        accountRepository.update(toAccount(accountDTO));


        return toDTO(transactionRepository.save(new Transaction(DEPOSIT,createRequest.getAmount(),toAccount(accountDTO))));
    }

    @WithdrawValidate
    @AtmStatus
    @MaxWithdraw
    @Override
   public TransactionDTO withdraw(TransactionCreateRequest createRequest) {

       AccountDTO accountDTO = toDto(accountRepository.findById(createRequest.getAccount().getId()));
        double balance = accountDTO.getAccountBalance() - createRequest.getAmount();
        accountDTO.setAccountBalance(balance);
        accountRepository.update(toAccount(accountDTO));
        // atmValues
        atmValues.put(accountDTO.getId(),createRequest.getAmount());

        return toDTO(transactionRepository.save(new Transaction(WITHDRAW,createRequest.getAmount(),toAccount(accountDTO))));
    }
    @TransferValidate
    @AtmStatus
    @MaxTransfer
    @Override
    public TransactionDTO transfer(TransactionCreateRequest createRequest, Integer accountIdReceiver) {
        AccountDTO sender =toDto(accountRepository.findById(createRequest.getAccount().getId()));
        AccountDTO receiver = toDto((accountRepository.findById(accountIdReceiver)));
        //sender
        double balanceSender = sender.getAccountBalance() - createRequest.getAmount();
        sender.setAccountBalance(balanceSender);
        accountRepository.update(toAccount(sender));
        //receiver
        double balanceReceiver = receiver.getAccountBalance() + createRequest.getAmount();
        receiver.setAccountBalance(balanceReceiver);
        accountRepository.update(toAccount(receiver));

        atmValues.put(sender.getId(),createRequest.getAmount());

        transactionRepository.save(new Transaction(SENDER,createRequest.getAmount(),toAccount(sender)));
        return toDTO(transactionRepository.save(new Transaction(RECEIVER,createRequest.getAmount(),toAccount(receiver))));

    }

    @Override
    public TransactionDTO findById(Integer id) {
        return toDTO(transactionRepository.findById(id));
    }

    @Override
    public TransactionDTO save(TransactionCreateRequest transactionCreateRequest) {
        return toDTO(transactionRepository.save(toTransaction(transactionCreateRequest)));
    }

    @Scheduled(cron = "0 0 0 * *  ?")
    public void atmResetValues(){
        atmValues.clear();
    }

    }





