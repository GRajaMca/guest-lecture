package com.javabeans.io.productcatalog.repository;

import com.javabeans.io.productcatalog.models.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
}
