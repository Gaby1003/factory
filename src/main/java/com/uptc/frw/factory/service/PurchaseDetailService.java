package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.PurchaseDetail;
import com.uptc.frw.factory.jpa.entity.key.PurchaseDetailKey;
import com.uptc.frw.factory.jpa.repository.PurchaseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseDetailService {


    @Autowired
    public PurchaseDetailRepository repository;

    public List<PurchaseDetail> findAllPurchaseDetail(){
        return repository.findAll();
    }

    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail){
        return repository.save(purchaseDetail);
    }

    public PurchaseDetail findPurchaseDetail(PurchaseDetailKey id){
        return repository.findById(id).get();
    }

    public void deletePurchaseDetail(PurchaseDetailKey id){
        repository.deleteById(id);
    }

    public PurchaseDetail updateQuantity(PurchaseDetailKey id, int quantity){
        PurchaseDetail purchaseDetail = findPurchaseDetail(id);
        purchaseDetail.setQuantity(quantity);
        return savePurchaseDetail(purchaseDetail);
    }
}
