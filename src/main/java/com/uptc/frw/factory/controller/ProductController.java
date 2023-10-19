package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.Product;
import com.uptc.frw.factory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public List<Product> findAllProducts() {
        return service.findAllProducts();
    }
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable Long idProduct) {
        return service.findProduct(idProduct);
    }
    @PostMapping
    public Product saveProdct(@RequestBody Product product) {
        return service.saveProdct(product);
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long idProduct,@RequestParam String name) {
        return service.updateProduct(idProduct, name);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long idProduct) {
        return service.deleteProduct(idProduct);
    }
}
