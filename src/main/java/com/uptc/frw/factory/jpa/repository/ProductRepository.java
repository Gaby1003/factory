package com.uptc.frw.factory.jpa.repository;

import com.uptc.frw.factory.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
