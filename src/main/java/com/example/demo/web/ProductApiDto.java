package com.example.demo.web;

import com.example.demo.domain.Product;
import lombok.Builder;

@Builder
public record ProductApiDto(
        Long id,
        String productName,
        String status
) {

    public static ProductApiDto from(Product product) {
        return ProductApiDto.builder()
                .id(product.id())
                .productName(product.productName())
                .status(product.status())
                .build();
    }
}
