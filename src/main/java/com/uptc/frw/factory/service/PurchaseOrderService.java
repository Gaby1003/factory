package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.PurchaseOrder;
import com.uptc.frw.factory.jpa.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    public PurchaseOrderRepository repository;

    public List<PurchaseOrder> findAllPurchaseOrder(){
        return repository.findAll();
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder){
        return repository.save(purchaseOrder);
    }

    public PurchaseOrder findPurchaseOrder(Long id){
        return repository.findById(id).get();
    }

    public void deletePurchaseOrder(Long id){
        repository.deleteById(id);
    }

    public PurchaseOrder updateRealDelivery(Long id, Date realDelivery){
        PurchaseOrder purchaseOrder = findPurchaseOrder(id);
        purchaseOrder.setRealDelivery(realDelivery);
        return savePurchaseOrder(purchaseOrder);
    }
}
