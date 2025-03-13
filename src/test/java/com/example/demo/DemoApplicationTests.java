package com.example.demo;

import com.example.demo.domain.Product;
import com.example.demo.web.ProductApiDto;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    private final MockMvcTester mockMvc;

    DemoApplicationTests(@Autowired WebApplicationContext wac) {
        this.mockMvc = MockMvcTester.from(wac).withHttpMessageConverters(
                List.of(wac.getBean(AbstractJackson2HttpMessageConverter.class)));
    }


    @Test
    void testGetAllProducts() throws Exception {
        MvcTestResult result = this.mockMvc.get().uri("/products").accept(MediaType.APPLICATION_JSON).exchange();
        assertThat(result).hasStatus(HttpStatus.OK).bodyJson().convertTo(InstanceOfAssertFactories.list(ProductApiDto.class)).hasSize(3);
    }

    @Test
    void testGetProductsByName() throws Exception {
        MvcTestResult result =
                this.mockMvc.get().uri("/products/query").param("name", "Product2").accept(MediaType.APPLICATION_JSON).exchange();
        assertThat(result).hasStatus(HttpStatus.OK).bodyJson().convertTo(InstanceOfAssertFactories.list(ProductApiDto.class)).hasSize(1).element(0)
                .isEqualTo(new ProductApiDto(2L, "Product2", "ACTIVE"));
    }


}
