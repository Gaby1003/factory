package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.ProductType;
import com.uptc.frw.factory.jpa.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    public ProductTypeRepository repository;

    @Autowired
    private LogService logService;

    public List<ProductType> productTypes(){
        List<ProductType> productTypes = repository.findAll();
        logService.createLogList(productTypes.getClass().getSimpleName(),productTypes);
        return productTypes;
    }
    public ProductType findProductType(Long idProductType){
        ProductType productType = repository.findById(idProductType).get();
        logService.createLogRead(productType.toString(),productType.getIdType().toString(),
                productType.getClass().getSimpleName());
        return productType;
    }
    public ProductType saveProductType(ProductType productType){
        logService.createLogAdd(productType.toString(), productType.getIdType().toString(),
                productType.getClass().getSimpleName());
        return repository.save(productType);
    }
    public String updateProductType(Long idProductType,String type){
        ProductType productType = findProductType(idProductType);
        ProductType productTypeAux = findProductType(idProductType);
        productType.setType(type);
        logService.createLogUpdate(productTypeAux.toString(),productType.toString(),
                productType.getIdType().toString(),productType.getClass().getSimpleName());
        repository.save(productType);
        return "Tipo de producto con ID "+idProductType+" actualizado con exito.";
    }
    public String deleteMaterial(Long idProductType){
        ProductType productType = repository.findById(idProductType).get();
        logService.createLogDelete(productType.toString(),productType.getIdType().toString(),
                productType.getClass().getSimpleName());
        repository.deleteById(idProductType);
        return "Tipo de producto con id "+idProductType+" eliminado con exito.";
    }
}
