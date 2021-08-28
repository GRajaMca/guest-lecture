package com.javabeans.io.productcatalog.service;

import com.javabeans.io.productcatalog.models.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long id);

    ProductDTO saveProduct(ProductDTO productDTO);

    void deleteProductById(Long id) throws Exception;

    ProductDTO updateProduct(ProductDTO productDTO, Long id) throws Exception;

}
