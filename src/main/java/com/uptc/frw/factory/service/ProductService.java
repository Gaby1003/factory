package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Product;
import com.uptc.frw.factory.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository repository;

    public List<Product> findAllProducts(){
        return repository.findAll();
    }
    public Product findProduct(Long idProduct){
        return repository.findById(idProduct).get();
    }
    public Product saveProdct(Product product){
        return repository.save(product);
    }
    public String updateProduct(Long idProduct,String name){
        Product product= findProduct(idProduct);
        product.setName(name);
        return "Producto con ID "+idProduct+" actualizado con exito.";
    }
    public String deleteProduct(Long idProduct){
        repository.deleteById(idProduct);
        return "Prodcto con id "+idProduct+" eliminado con exito.";
    }
}
