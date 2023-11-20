package com.ATMproject.ATM.service.impl;

import com.ATMproject.ATM.mapper.AccountMapper;
import com.ATMproject.ATM.model.dto.AccountCreateRequest;
import com.ATMproject.ATM.model.dto.AccountDTO;
import com.ATMproject.ATM.model.entity.Account;
import com.ATMproject.ATM.repository.AccountRepository;
import com.ATMproject.ATM.service.AccountService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.ATMproject.ATM.mapper.AccountMapper.toAccount;
import static com.ATMproject.ATM.mapper.AccountMapper.toDto;

@Transactional
@Service
@Qualifier("AccountServiceDB")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public AccountDTO save(AccountCreateRequest accountCreateRequest) {
        return toDto(accountRepository.save(toAccount(accountCreateRequest)));
    }


    @Override
    public AccountDTO update(AccountCreateRequest accountCreateRequest,Integer id) {
        AccountDTO accountDTO = toDto(accountCreateRequest);
        accountDTO.setId(id);
        return toDto(accountRepository.update(toAccount(accountDTO)));
    }

    @Override
    public AccountDTO findById(Integer id) {
       return toDto(accountRepository.findById(id));
    }

    @Override
    public AccountDTO delete(Integer id) {
        Account entity = accountRepository.findById(id);
        return toDto(accountRepository.delete(entity));
    }
}
