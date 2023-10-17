package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.PurchaseDetail;
import com.uptc.frw.factory.jpa.entity.key.PurchaseDetailKey;
import com.uptc.frw.factory.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseDetail")
public class PurchaseDetailController {

    @Autowired
    private PurchaseDetailService service;

    @GetMapping
    public List<PurchaseDetail> findAll(){
        return service.findAllPurchaseDetail();
    }

    @PostMapping
    public PurchaseDetail savePurchaseDetail(@RequestBody PurchaseDetail purchaseDetail){
        return service.savePurchaseDetail(purchaseDetail);
    }

    @GetMapping("/purchaseDetail")
    public PurchaseDetail findPurchaseDetail(@RequestBody PurchaseDetailKey id){
        return service.findPurchaseDetail(id);
    }

    @DeleteMapping
    public void deletePurchaseDetail(@RequestBody PurchaseDetailKey id){
        service.deletePurchaseDetail(id);
    }

    @PutMapping
    public PurchaseDetail updateQuantity(@RequestBody PurchaseDetailKey id,
                                             @RequestParam int quantity){
        return service.updateQuantity(id, quantity);
    }
}
