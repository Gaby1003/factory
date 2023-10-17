package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
