package com.example.Spring_jpa_product.repository;

import com.example.Spring_jpa_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByprdCategory(String prdCategory);

}
