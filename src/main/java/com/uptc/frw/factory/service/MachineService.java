package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Machine;
import com.uptc.frw.factory.jpa.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private LogService logService;

    @Autowired
    public MachineRepository repository;

    public List<Machine> findAllMachine(){
        List<Machine> machines = repository.findAll();
        logService.createLogList(machines.getClass().getSimpleName(), machines);
        return machines;
    }

    public Machine saveMachine(Machine machine){
        logService.createLogAdd(machine.toString(), machine.getSerialNumber().toString(),
                machine.getClass().getSimpleName());
        return repository.save(machine);
    }

    public Machine findMachine(Long id){
        Machine machine = repository.findById(id).get();
        logService.createLogRead(machine.toString(),machine.getSerialNumber().toString(),
                machine.getClass().getSimpleName());
        return machine;
    }

    public void deleteMachine(Long id){
        Machine machine = repository.findById(id).get();
        logService.createLogDelete(machine.toString(),machine.getSerialNumber().toString(),
                machine.getClass().getSimpleName());
        repository.deleteById(id);
    }

    public Machine updateModel(Long id, String model){
        Machine machine = findMachine(id);
        Machine machineAux = findMachine(id);
        machine.setModel(model);
        logService.createLogUpdate(machineAux.toString(),machine.toString(),
                machine.getSerialNumber().toString(),machine.getClass().getSimpleName());
        return saveMachine(machine);
    }
}
