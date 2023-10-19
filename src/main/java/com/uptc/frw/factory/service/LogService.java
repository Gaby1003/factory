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




}
