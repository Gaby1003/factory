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
        logService.createLogList(details.getClass().getSimpleName(),details);
        return details;
    }

    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail){
        logService.createLogAdd(purchaseDetail.toString(), new  PurchaseDetailKey(
                    purchaseDetail.getProductId(), purchaseDetail.getOrderId()
                ).toString(),
                purchaseDetail.getClass().getSimpleName());
        return repository.save(purchaseDetail);
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
        PurchaseDetail purchaseDetailAux = findPurchaseDetail(id);
        purchaseDetail.setQuantity(quantity);
        logService.createLogUpdate(purchaseDetailAux.toString(),purchaseDetail.toString(),
                id.toString(),purchaseDetail.getClass().getSimpleName());
        return savePurchaseDetail(purchaseDetail);
    }
}
