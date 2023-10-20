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

    @Autowired
    private LogService logService;

    public List<Product> findAllProducts(){
        List<Product> products = repository.findAll();
        //logService.createLogList(Product.class.getSimpleName(),products);
        return products;
    }
    public Product findProduct(Long idProduct){
        Product product = repository.findById(idProduct).get();
        logService.createLogRead(product.toString(),product.getIdProduct().toString(),
                product.getClass().getSimpleName());
        return product;
    }
    public Product saveProduct(Product product){
        Product productAux = repository.save(product);
        logService.createLogAdd(product.toString(), String.valueOf(product.getIdProduct()),
                product.getClass().getSimpleName());
        return productAux;
    }
    public String updateProduct(Long idProduct,String name){
        Product product= findProduct(idProduct);
        String productAux= findProduct(idProduct).toString();
        product.setName(name);
        logService.createLogUpdate(productAux,product.toString(),
                product.getIdProduct().toString(),product.getClass().getSimpleName());
        repository.save(product);
        return "Producto con ID "+idProduct+" actualizado con exito.";
    }
    public String deleteProduct(Long idProduct){
        Product product = repository.findById(idProduct).get();
        logService.createLogDelete(product.toString(),product.getIdProduct().toString(),
                product.getClass().getSimpleName());
        repository.deleteById(idProduct);
        return "Prodcto con id "+idProduct+" eliminado con exito.";
    }
}
