package com.example.demo.web;

import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductApiDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts().stream().map(ProductApiDto::from).toList());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(Long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @RequestMapping("/query")
    public ResponseEntity<List<ProductApiDto>> getProductsByName(@RequestParam("productName") String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
