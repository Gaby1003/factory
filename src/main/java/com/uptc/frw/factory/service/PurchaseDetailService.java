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

    @Autowired
    private LogService logService;

    public List<PurchaseDetail> findAllPurchaseDetail(){
        List<PurchaseDetail> details = repository.findAll();
        logService.createLogList(PurchaseDetail.class.getSimpleName(),details);
        return details;
    }

    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail){
        PurchaseDetail purchaseDetailAux = repository.save(purchaseDetail);
        PurchaseDetailKey purchaseDetailKey = new  PurchaseDetailKey(
                purchaseDetail.getProductId(), purchaseDetail.getOrderId());
        logService.createLogAdd(purchaseDetailAux.toString(), purchaseDetailKey.toString(),
                purchaseDetail.getClass().getSimpleName());
        return purchaseDetailAux;
    }

    public PurchaseDetail findPurchaseDetail(PurchaseDetailKey id){
        PurchaseDetail detail = repository.findById(id).get();
        logService.createLogRead(detail.toString(),id.toString(),
                detail.getClass().getSimpleName());
        return detail;
    }

    public void deletePurchaseDetail(PurchaseDetailKey id){
        PurchaseDetail detail = repository.findById(id).get();
        logService.createLogDelete(detail.toString(),id.toString(),
                detail.getClass().getSimpleName());
        repository.deleteById(id);
    }

    public PurchaseDetail updateQuantity(PurchaseDetailKey id, int quantity){
        PurchaseDetail purchaseDetail = findPurchaseDetail(id);
        String purchaseDetailAux = findPurchaseDetail(id).toString();
        purchaseDetail.setQuantity(quantity);
        logService.createLogUpdate(purchaseDetailAux,purchaseDetail.toString(),
                id.toString(),purchaseDetail.getClass().getSimpleName());
        return savePurchaseDetail(purchaseDetail);
    }
}
