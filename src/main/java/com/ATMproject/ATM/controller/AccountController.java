package com.ATMproject.ATM.controller;

import com.ATMproject.ATM.model.dto.AccountCreateRequest;
import com.ATMproject.ATM.model.dto.AccountDTO;
import com.ATMproject.ATM.model.dto.CustomerDTO;
import com.ATMproject.ATM.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Integer accountId){
        AccountDTO accountDTO = accountService.findById(accountId);
        return accountDTO != null? ResponseEntity.ok(accountDTO):ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public void save(@RequestBody AccountCreateRequest createRequest){
         accountService.save(createRequest);

    }
   @PutMapping("/{userId}")
    public void update(@RequestBody AccountCreateRequest accountCreateRequest,@PathVariable int userId){
        accountService.update(accountCreateRequest,userId);
   }

   @DeleteMapping("{userId}")
    public void delete(@PathVariable Integer userId){

        accountService.delete(userId);
   }
}
