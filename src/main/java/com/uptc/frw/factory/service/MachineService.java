package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Machine;
import com.uptc.frw.factory.jpa.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    public MachineRepository repository;

    public List<Machine> findAllMachine(){
        return repository.findAll();
    }

    public Machine saveMachine(Machine machine){
        return repository.save(machine);
    }

    public Machine findMachine(Long id){
        return repository.findById(id).get();
    }

    public void deleteMachine(Long id){
        repository.deleteById(id);
    }

    public Machine updateModel(Long id, String model){
        Machine machine = findMachine(id);
        machine.setModel(model);
        return saveMachine(machine);
    }
}
