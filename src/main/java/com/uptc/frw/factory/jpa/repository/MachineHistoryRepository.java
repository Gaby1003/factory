package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.MachineHistory;
import com.uptc.frw.factory.jpa.entity.key.MachineHistoryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineHistoryRepository extends JpaRepository<MachineHistory, MachineHistoryKey> {
}
