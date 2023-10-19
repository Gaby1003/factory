package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine,String> {
}
