package com.example.demo.web;

import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductApiDto> getAllProducts() {
        return productService.getAllProducts().stream().map(ProductApiDto::from).toList();
    }

    @GetMapping
    @RequestMapping("/query")
    public List<ProductApiDto> getProductsByName(@RequestParam("productName") String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
