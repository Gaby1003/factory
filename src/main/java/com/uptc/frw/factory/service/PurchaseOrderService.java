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

    @Autowired
    private LogService logService;

    public List<PurchaseOrder> findAllPurchaseOrder(){
        List<PurchaseOrder> orders = repository.findAll();
        logService.createLogList(orders.getClass().getSimpleName(),orders);
        return orders;
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder){
        logService.createLogAdd(purchaseOrder.toString(), purchaseOrder.getId().toString(),
                purchaseOrder.getClass().getSimpleName());
        return repository.save(purchaseOrder);
    }

    public PurchaseOrder findPurchaseOrder(Long id){
        PurchaseOrder order = repository.findById(id).get();
        logService.createLogRead(order.toString(),order.getId().toString(),
                order.getClass().getSimpleName());
        return order;
    }

    public void deletePurchaseOrder(Long id){
        PurchaseOrder order = repository.findById(id).get();
        logService.createLogDelete(order.toString(),order.getId().toString(),
                order.getClass().getSimpleName());
        repository.deleteById(id);
    }

    public PurchaseOrder updateRealDelivery(Long id, Date realDelivery){
        PurchaseOrder purchaseOrder = findPurchaseOrder(id);
        PurchaseOrder purchaseOrderAux = findPurchaseOrder(id);
        purchaseOrder.setRealDelivery(realDelivery);
        logService.createLogUpdate(purchaseOrderAux.toString(),purchaseOrder.toString(),
                purchaseOrder.getId().toString(),purchaseOrder.getClass().getSimpleName());
        return repository.save(purchaseOrder);
    }
}
