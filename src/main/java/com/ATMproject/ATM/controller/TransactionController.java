package com.ATMproject.ATM.controller;

import com.ATMproject.ATM.model.dto.TransactionCreateRequest;
import com.ATMproject.ATM.model.dto.TransactionDTO;
import com.ATMproject.ATM.model.entity.Transaction;
import com.ATMproject.ATM.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {


    private TransactionService transactionService;
    TransactionController(TransactionService theService){
        transactionService = theService;
    }

    @PostMapping("/deposit")
    public TransactionDTO deposit(@RequestBody TransactionCreateRequest createRequest){
        return transactionService.deposit(createRequest);
    }
    @GetMapping("/{transactionId}")
    public TransactionDTO findById(@PathVariable Integer transactionId){
        return transactionService.findById(transactionId);
    }
    @PostMapping
    public TransactionDTO save(@RequestBody TransactionCreateRequest transactionCreateRequest){
        return transactionService.save(transactionCreateRequest);
    }
    @PostMapping("/withdraw")
    public TransactionDTO withdraw(@RequestBody TransactionCreateRequest createRequest){
        return transactionService.withdraw(createRequest);
    }
    @PostMapping("/transfer/{receiver}")
    public TransactionDTO transfer(@RequestBody TransactionCreateRequest createRequest , @PathVariable int receiver){
        return transactionService.transfer(createRequest,receiver);

    }

}
