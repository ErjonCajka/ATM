package com.ATMproject.ATM.repository;

import com.ATMproject.ATM.model.dto.AccountCreateRequest;
import com.ATMproject.ATM.model.dto.AccountDTO;
import com.ATMproject.ATM.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;


public interface AccountRepository  {
    Account save(Account accountCreateRequest);
    Account update(Account accountDTO);
    Account findById(Integer id);
    Account delete(Account account);

}
