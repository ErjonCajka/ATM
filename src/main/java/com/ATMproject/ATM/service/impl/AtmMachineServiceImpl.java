package com.ATMproject.ATM.service.impl;

import com.ATMproject.ATM.model.entity.AtmMachine;
import com.ATMproject.ATM.repository.AtmMachineRepository;
import com.ATMproject.ATM.service.AtmMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtmMachineServiceImpl implements AtmMachineService {
    @Autowired
    AtmMachineRepository atmMachineRepository;
    @Override
    public Optional<AtmMachine> findById(Integer id) {
       return atmMachineRepository.findById(id);
    }
}
