package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.MachineHistory;
import com.uptc.frw.factory.jpa.entity.key.MachineHistoryKey;
import com.uptc.frw.factory.service.MachineHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/machineHistory")
public class MachineHistoryController {

    @Autowired
    private MachineHistoryService service;

    @GetMapping
    public List<MachineHistory> findAll(){
        return service.findAllMachineHistory();
    }

    @PostMapping
    public MachineHistory saveMachineHistory(@RequestBody MachineHistory machineHistory){
        return service.saveMachineHistory(machineHistory);
    }

    @GetMapping("/machineHistory")
    public MachineHistory findMachineHistory(@RequestBody MachineHistoryKey id){
        return service.findMachineHistory(id);
    }

    @DeleteMapping
    public void deleteMachineHistory(@RequestBody MachineHistoryKey id){
        service.deleteMachineHistory(id);
    }

}
