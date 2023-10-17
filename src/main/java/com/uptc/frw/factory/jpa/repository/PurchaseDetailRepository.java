package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.PurchaseDetail;
import com.uptc.frw.factory.jpa.entity.key.PurchaseDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, PurchaseDetailKey> {
}
