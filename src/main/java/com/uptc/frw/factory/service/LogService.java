package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Log;
import com.uptc.frw.factory.jpa.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void createLogIndexBulk(final List<Log> logs) {
        logRepository.saveAll(logs);
    }

    public void createLogIndex(final Log log) {
        logRepository.save(log);
    }

    public void createLogAdd(String data, String id, String table){
        String description = "creacion de nuevo registro en la base de datos";
        Log log = new Log(description,"CREATE",null,data,id,table);
        logRepository.save(log);

    }
    public void createLogUpdate(String dataBefore,String dataAfter, String id, String table){
        String description = "actualización de registro en la base de datos";
        Log log = new Log(description,"UPDATE",dataBefore,dataAfter,id,table);
        logRepository.save(log);
    }
    public void createLogDelete(String dataBefore, String id, String table){
        String description = "eliminación de registro en la base de datos";
        Log log = new Log(description,"DELETE",dataBefore,null,id,table);
        logRepository.save(log);

    }
    public void createLogRead(String data, String id, String table){
        String description = "lectura de registro en la base de datos";
        Log log = new Log(description,"READ",null,data,id,table);
        logRepository.save(log);
    }

    public void createLogList( String table, List list){
        String description = "lectura de registro en la base de datos";
        Log log = new Log(description,"READ_ALL",table,list);
        logRepository.save(log);
    }



}
