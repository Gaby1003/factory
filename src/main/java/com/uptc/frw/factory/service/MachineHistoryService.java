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
    @Autowired
    private LogService logService;

    public List<MachineHistory> findAllMachineHistory(){
        List<MachineHistory> history = repository.findAll();
        logService.createLogList(history.getClass().getSimpleName(),history);
        return history;
    }

    public MachineHistory saveMachineHistory(MachineHistory machineHistory){
        MachineHistory history = repository.save(machineHistory);
        logService.createLogAdd(history.toString(), new MachineHistoryKey(
                        history.getWorkerId(), history.getMachineId(), history.getDate())
                        .toString(),
                history.getClass().getSimpleName());
        return history;
    }

    public MachineHistory findMachineHistory(MachineHistoryKey id){
        MachineHistory history = repository.findById(id).get();
        logService.createLogRead(history.toString(), id.toString(),
                   history.getClass().getSimpleName());
        return history;
    }

    public void deleteMachineHistory(MachineHistoryKey id){
        MachineHistory history = repository.findById(id).get();
        logService.createLogDelete(history.toString(), id.toString(),
                history.getClass().getSimpleName());
        repository.deleteById(id);
    }

}
