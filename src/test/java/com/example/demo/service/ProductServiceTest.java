package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.persistence.ProductEntity;
import com.example.demo.persistence.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Test
    void getAllProducts() {
        List<ProductEntity> list = List.of(new ProductEntity(1L, "Product 1", "ACTIVE"));
        when(productRepository.findAll()).thenReturn(list);

        List<Product> result = new ProductService(productRepository).getAllProducts();

        assertEquals(result.size(), 1);
    }
}