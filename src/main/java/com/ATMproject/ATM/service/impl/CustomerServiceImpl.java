package com.ATMproject.ATM.service.impl;

import com.ATMproject.ATM.model.dto.CustomerDTO;
import com.ATMproject.ATM.exception.ResourceNotFoundException;
import com.ATMproject.ATM.mapper.CustomerMapper;
import com.ATMproject.ATM.repository.CustomerRepository;
import com.ATMproject.ATM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ATMproject.ATM.mapper.CustomerMapper.toDTO;
import static com.ATMproject.ATM.mapper.CustomerMapper.toDTOList;

@Service
@Qualifier("cutomerServiceDB")
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository theCustomer){
        customerRepository = theCustomer;
    }

    @Override
    public CustomerDTO findById(Integer id) {
       return toDTO(customerRepository.findById(id));

    }

    @Override
    public List<CustomerDTO> findAll(int pageNumber, int size) {
        return toDTOList(customerRepository.findAll(pageNumber,size));
    }
}
