package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.persistence.ProductEntity;
import com.example.demo.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<ProductEntity> entities = productRepository.findAll();
        return entities.stream()
                .map(Product::from).toList();
    }
}
