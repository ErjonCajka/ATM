package com.ATMproject.ATM.service;

import com.ATMproject.ATM.model.dto.AccountCreateRequest;
import com.ATMproject.ATM.model.dto.AccountDTO;

import java.util.List;

public interface AccountService {



    AccountDTO save(AccountCreateRequest accountCreateRequest);
    AccountDTO update(AccountCreateRequest accountCreateRequest,Integer id);
    AccountDTO findById(Integer id);
    AccountDTO delete(Integer id);


}
