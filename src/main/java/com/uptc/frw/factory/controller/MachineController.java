package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.Machine;
import com.uptc.frw.factory.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/machine")
public class MachineController {

    @Autowired
    private MachineService service;

    @GetMapping
    public List<Machine> findAll(){
        return service.findAllMachine();
    }

    @PostMapping
    public Machine saveMachine(@RequestBody Machine machine){
        return service.saveMachine(machine);
    }

    @GetMapping("/{id}")
    public Machine findMachine(@PathVariable Long id){
        return service.findMachine(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable Long id){
        service.deleteMachine(id);
    }

    @PutMapping("/{id}")
    public Machine updateModel(@PathVariable Long id, @RequestParam String model){
        return service.updateModel(id, model);
    }
}
