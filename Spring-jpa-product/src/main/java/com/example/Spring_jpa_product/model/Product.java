package com.example.Spring_jpa_product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prdId;
    private String prdName;
    private long prdPrice;
    private String prdCategory;

}
