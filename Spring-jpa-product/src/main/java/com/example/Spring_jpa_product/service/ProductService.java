package com.example.Spring_jpa_product.service;

import com.example.Spring_jpa_product.model.Product;
import com.example.Spring_jpa_product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product)
    {
        productRepository.save(product);
        return "products saved successfully";
    }

    public List<Product> displayAll()
    {
        return productRepository.findAll();
    }

    public List<Product> findByCategory(String category)
    {
        return productRepository.findByprdCategory(category);
    }

}
