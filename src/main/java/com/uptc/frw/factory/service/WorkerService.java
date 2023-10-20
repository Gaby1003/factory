package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Skill;
import com.uptc.frw.factory.jpa.entity.Worker;
import com.uptc.frw.factory.jpa.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    public WorkerRepository repository;

    @Autowired
    private LogService logService;

    public List<Skill> saveSkillsWorker(Long id, List<Skill> skills){
        Worker worker = findWorker(id);
        worker.setSkillList(skills);
        repository.save(worker);
        return skills;
    }

    public List<Worker> findAllWorker(){
        List<Worker> workers = repository.findAll();
        //logService.createLogList(Worker.class.getSimpleName(),workers);
        return workers;
    }
    public Worker saveWorker(Worker worker){
        Worker workerAux = repository.save(worker);
        logService.createLogAdd(worker.toString(), String.valueOf(workerAux.getId()),
                worker.getClass().getSimpleName());
        return workerAux;
    }
    public Worker findWorker(Long id){
        Worker worker =  repository.findById(id).get();
        logService.createLogRead(worker.toString(),worker.getId().toString(),
                worker.getClass().getSimpleName());
        return worker;
    }
    public  void deleteWorker(Long id){
        Worker worker = repository.findById(id).get();
        logService.createLogDelete(worker.toString(),worker.getId().toString(),
                worker.getClass().getSimpleName());
        repository.deleteById(id);
    }
    public Worker updateAddress(Long id,String address){
        Worker worker = findWorker(id);
        String workerAux = findWorker(id).toString();
        worker.setAddress(address);
        logService.createLogUpdate(workerAux,worker.toString(),
                worker.getId().toString(),worker.getClass().getSimpleName());
        return repository.save(worker);
    }
}
