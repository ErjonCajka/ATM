package com.ATMproject.ATM.service;

import com.ATMproject.ATM.model.dto.CustomerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    CustomerDTO findById(Integer id);
    List<CustomerDTO> findAll(int pageNumber, int size);
}
