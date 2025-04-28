package com.playdata.orderservice.product.repository;

import com.playdata.orderservice.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;



public interface ProductRepository extends JpaRepository<Product, Long> {

    // 검색 조건(카테고리, 검색어))에 따른 페이징
    @Query("select  p from Product p where p.category like %?1% ")
    Page<Product> findByCategoryValue(String keyword, Pageable pageable);

    @Query("select  p from Product p where p.name like %?1% ")
    Page<Product> findByNameValue(String keyword, Pageable pageable);
}
