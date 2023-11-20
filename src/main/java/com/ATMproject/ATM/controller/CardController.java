package com.ATMproject.ATM.controller;

import com.ATMproject.ATM.model.dto.CardDTO;
import com.ATMproject.ATM.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;
    @GetMapping("/{cardId}")
    public ResponseEntity<CardDTO> findById(@PathVariable Integer cardId){
        CardDTO cardDTO = cardService.findById(cardId);
        return cardDTO != null? ResponseEntity.ok(cardDTO):ResponseEntity.notFound().build();
    }


}
