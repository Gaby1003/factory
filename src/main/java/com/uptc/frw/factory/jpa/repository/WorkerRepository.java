package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
