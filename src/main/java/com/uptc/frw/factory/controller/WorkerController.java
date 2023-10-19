package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.Skill;
import com.uptc.frw.factory.jpa.entity.Worker;
import com.uptc.frw.factory.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService service;
    @GetMapping
    public List<Worker> findAll() {
        return service.findAllWorker();
    }
    @PostMapping
    public Worker saveWorker(@RequestBody Worker worker){
        return service.saveWorker(worker);
    }
    @GetMapping("/{id}")
    public Worker findWorker(@PathVariable Long id) {
        return service.findWorker(id);
    }
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id){
        service.deleteWorker(id);
    }
    @PutMapping("/{id}")
    public Worker updateWorker(@PathVariable Long id,@RequestParam String address){
        return service.updateAddress(id,address);
    }
    @PostMapping("/skills")
    public List<Skill> saveSkillsWorker(@PathVariable Long id, @RequestBody List<Skill> skills){
        return service.saveSkillsWorker(id, skills);
    }
}
