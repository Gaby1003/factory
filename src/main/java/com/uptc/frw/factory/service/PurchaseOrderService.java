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
        //logService.createLogList(PurchaseOrder.class.getSimpleName(),orders);
        return orders;
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder){
        PurchaseOrder purchaseOrderAux = repository.save(purchaseOrder);
        logService.createLogAdd(purchaseOrder.toString(), String.valueOf(purchaseOrder.getId()),
                purchaseOrder.getClass().getSimpleName());
        return purchaseOrderAux;
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
        String purchaseOrderAux = findPurchaseOrder(id).toString();
        purchaseOrder.setRealDelivery(realDelivery);
        logService.createLogUpdate(purchaseOrderAux,purchaseOrder.toString(),
                purchaseOrder.getId().toString(),purchaseOrder.getClass().getSimpleName());
        return repository.save(purchaseOrder);
    }
}
