package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.PurchaseOrder;
import com.uptc.frw.factory.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @GetMapping
    public List<PurchaseOrder> findAll(){
        return service.findAllPurchaseOrder();
    }

    @PostMapping
    public PurchaseOrder savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
        return service.savePurchaseOrder(purchaseOrder);
    }

    @GetMapping("/{id}")
    public PurchaseOrder findPurchaseOrder(@PathVariable Long id){
        return service.findPurchaseOrder(id);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrder(@PathVariable Long id){
        service.deletePurchaseOrder(id);
    }

    @PutMapping("/{id}")
    public PurchaseOrder updateRealDelivery(@PathVariable Long id, @RequestBody String realDelivery) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        return service.updateRealDelivery(id, format.parse(realDelivery));
    }
}
