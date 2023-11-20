package com.ATMproject.ATM.controller;

import com.ATMproject.ATM.model.dto.CustomerDTO;
import com.ATMproject.ATM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

private CustomerService customerService;
CustomerController(CustomerService theService){
    customerService = theService;
}

@GetMapping("/{userId}")
public ResponseEntity<CustomerDTO> findById(@PathVariable int userId){
    CustomerDTO customerDTO = customerService.findById(userId);
   return customerDTO != null ? ResponseEntity.ok(customerDTO) :ResponseEntity.notFound().build();
}
@GetMapping("/{pageNumber}/{size}")
    public List<CustomerDTO> findAll(@PathVariable int pageNumber, @PathVariable int size){
    return customerService.findAll(pageNumber,size);
}
}
