package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Worker;
import com.uptc.frw.factory.jpa.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    public WorkerRepository repository;

    public List<Worker> findAllWorker(){return repository.findAll();}
    public Worker saveWorker(Worker worker){return repository.save(worker);}
    public Worker findWorker(Long id){return repository.findById(id).get();}
    public  void deleteWorker(Long id){repository.deleteById(id); }
    public Worker updateAddress(Long id,String address){
        Worker worker = findWorker(id);
        worker.setAddress(address);
        return saveWorker(worker);
    }
}
