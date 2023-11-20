package com.ATMproject.ATM.repository;

import com.ATMproject.ATM.model.entity.AtmMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmMachineRepository extends JpaRepository<AtmMachine,Integer> {
}
