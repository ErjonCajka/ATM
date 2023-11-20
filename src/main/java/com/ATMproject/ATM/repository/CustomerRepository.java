package com.ATMproject.ATM.repository;

import com.ATMproject.ATM.model.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerRepository {
    Customer findById(int id);
    List<Customer>findAll(int pageNumber, int pageSize);

}
