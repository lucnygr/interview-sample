package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.persistence.ProductEntity;
import com.example.demo.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    /**
     * Returns all available {@link Product}s.
     *
     * @return a list of products or an empty list if nothing was found.
     */
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        List<ProductEntity> entities = productRepository.findAll();
        return entities.stream()
                .map(Product::from).toList();
    }

    @Transactional
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
