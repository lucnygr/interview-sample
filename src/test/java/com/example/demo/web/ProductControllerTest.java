package com.example.demo.web;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    void getAllProducts() throws Exception {
        List<Product> list = List.of(new Product(1L, "P1", "ACTIVE"));
        when(productService.getAllProducts()).thenReturn(list);

        this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                [{
                                  "id": 1,
                                  "productName": "P1",
                                  "status": "ACTIVE"
                                }]
                                """
                ));
    }
}