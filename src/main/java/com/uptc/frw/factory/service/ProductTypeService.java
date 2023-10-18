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
    public List<ProductType> productTypes(){
        return repository.findAll();
    }
    public ProductType findProductType(Long idProductType){
        return repository.findById(idProductType).get();
    }
    public ProductType saveProductType(ProductType productType){
        return repository.save(productType);
    }
    public String updateProductType(Long idProductType,String type){
        ProductType productType=findProductType(idProductType);
        productType.setType(type);
        return "Tipo de producto con ID "+idProductType+" actualizado con exito.";
    }
    public String deleteMaterial(Long idProductType){
        repository.deleteById(idProductType);
        return "Tipo de producto con id "+idProductType+" eliminado con exito.";
    }
}
