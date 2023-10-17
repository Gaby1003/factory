package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
