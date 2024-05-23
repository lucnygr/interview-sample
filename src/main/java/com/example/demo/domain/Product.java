package com.example.demo.domain;

import com.example.demo.persistence.ProductEntity;
import lombok.Builder;

@Builder
public record Product(
        Long id,
        String productName,
        String status
) {

    public static Product from(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .productName(productEntity.getProductName())
                .status(productEntity.getStatus())
                .build();
    }
}
