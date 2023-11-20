package com.ATMproject.ATM.mapper;

import com.ATMproject.ATM.model.dto.AccountCreateRequest;
import com.ATMproject.ATM.model.dto.AccountDTO;
import com.ATMproject.ATM.model.entity.Account;

public class AccountMapper {

    public static AccountDTO toDto(Account account){
        AccountDTO toReturn = new AccountDTO();
        toReturn.setId(account.getId());
        toReturn.setAccountType(account.getAccountType());
        toReturn.setAccountBalance(account.getAccountBalance());
        toReturn.setAccountNumber(account.getAccountNumber());
        toReturn.setUser(account.getUser());
        toReturn.setCard(account.getCard());
        toReturn.setCustomer(account.getCustomer());
        return toReturn;
    }
    public static Account toAccount(AccountCreateRequest accountCreateRequest){
        Account account = new Account();
        account.setAccountNumber(accountCreateRequest.getAccountNumber());
        account.setAccountBalance(accountCreateRequest.getAccountBalance());
        account.setAccountType(accountCreateRequest.getAccountType());
        account.setUser(accountCreateRequest.getUser());
        account.setCard(accountCreateRequest.getCard());
        account.setCustomer(accountCreateRequest.getCustomer());
        return account;
    }
    public static Account toAccount(AccountDTO accountDTO){
        Account toReturn = new Account();
        toReturn.setId(accountDTO.getId());
        toReturn.setAccountType(accountDTO.getAccountType());
        toReturn.setAccountBalance(accountDTO.getAccountBalance());
        toReturn.setAccountNumber(accountDTO.getAccountNumber());
        toReturn.setUser(accountDTO.getUser());
        toReturn.setCard(accountDTO.getCard());
        toReturn.setCustomer(accountDTO.getCustomer());
        return toReturn;
    }
    public static AccountDTO toDto(AccountCreateRequest accountCreateRequest){
        AccountDTO account = new AccountDTO();
        account.setAccountNumber(accountCreateRequest.getAccountNumber());
        account.setAccountBalance(accountCreateRequest.getAccountBalance());
        account.setAccountType(accountCreateRequest.getAccountType());
        account.setUser(accountCreateRequest.getUser());
        account.setCard(accountCreateRequest.getCard());
        account.setCustomer(accountCreateRequest.getCustomer());
        return account;
    }
}
