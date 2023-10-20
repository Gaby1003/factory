package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.ProductType;
import com.uptc.frw.factory.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService service;

    @GetMapping
    public List<ProductType> productTypes() {
        return service.findAllProductTypes();
    }
    @GetMapping("/{idProductType}")
    public ProductType findProductType(@PathVariable Long idProductType) {
        return service.findProductType(idProductType);
    }
    @PostMapping
    public ProductType saveProductType(@RequestBody ProductType productType) {
        return service.saveProductType(productType);
    }
    @PutMapping("/{idProductType}")
    public String updateProductType(@PathVariable Long idProductType,@RequestParam String type) {
        return service.updateProductType(idProductType, type);
    }
    @DeleteMapping("/{idProductType}")
    public String deleteMaterial(@PathVariable Long idProductType) {
        return service.deleteMaterial(idProductType);
    }
}
