package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.MachineHistory;
import com.uptc.frw.factory.jpa.entity.key.MachineHistoryKey;
import com.uptc.frw.factory.jpa.repository.MachineHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineHistoryService {

    @Autowired
    public MachineHistoryRepository repository;

    public List<MachineHistory> findAllMachineHistory(){
        return repository.findAll();
    }

    public MachineHistory saveMachineHistory(MachineHistory machineHistory){
        return repository.save(machineHistory);
    }

    public MachineHistory findMachineHistory(MachineHistoryKey id){
        return repository.findById(id).get();
    }

    public void deleteMachineHistory(MachineHistoryKey id){
        repository.deleteById(id);
    }

}
