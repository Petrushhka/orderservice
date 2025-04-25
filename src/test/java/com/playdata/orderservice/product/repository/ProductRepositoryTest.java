package com.playdata.orderservice.product.repository;

import com.playdata.orderservice.product.entity.Product;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("벌크데이터")
    void bulkInsert() {
        // given
        for (int i = 0; i < 50; i++) {
           Product p = Product.builder()
                    .name("상품 "+i)
                    .category("카테고리 "+i)
                    .stockQuantity(100)
                    .price(3000)
                    .build();
            productRepository.save(p);
        }
        // when

        // then
    }

}