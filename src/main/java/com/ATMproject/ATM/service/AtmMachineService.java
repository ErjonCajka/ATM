package com.ATMproject.ATM.service;

import com.ATMproject.ATM.model.entity.AtmMachine;

import java.util.Optional;


public interface AtmMachineService {
    Optional<AtmMachine> findById(Integer id);
}
