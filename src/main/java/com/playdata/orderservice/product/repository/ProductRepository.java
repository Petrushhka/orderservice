package com.playdata.orderservice.product.repository;

import com.playdata.orderservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
