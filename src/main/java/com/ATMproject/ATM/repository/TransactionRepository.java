package com.ATMproject.ATM.repository;

import com.ATMproject.ATM.model.entity.Transaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface TransactionRepository {
Transaction save (Transaction transaction);
Transaction update (Transaction transaction);
Transaction findById(Integer id);
}
