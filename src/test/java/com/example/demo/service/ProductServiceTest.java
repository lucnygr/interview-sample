package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.persistence.ProductEntity;
import com.example.demo.persistence.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        if (result == null) {
            throw new IllegalStateException("Result is null");
        }
        assertEquals(result.size(), 1);
    }

    @Test
    void deleteProduct() {
        Assertions.assertThatNoException().isThrownBy(() ->
                this.productRepository.deleteById(2L));
    }

    @Test
    void getProductsByName() {
        // TODO implement test
    }
}