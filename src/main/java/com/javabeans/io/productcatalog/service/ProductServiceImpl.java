package com.javabeans.io.productcatalog.service;

import com.javabeans.io.productcatalog.models.ProductDTO;
import com.javabeans.io.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return this.productRepository.save(productDTO);
    }

    @Override
    public void deleteProductById(Long id) throws Exception {
        ProductDTO productDTO = this.productRepository.getById(id);
        if (productDTO.getId() != null) {
            this.productRepository.delete(productDTO);
        } else {
            throw new Exception("Data is not available");
        }

    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long id) throws Exception {
        ProductDTO existingProduct = this.productRepository.getById(id);
        if (existingProduct.getId() == null) {
            throw new Exception("Data is not available");
        }
        existingProduct.setBrand(productDTO.getBrand());
        return this.productRepository.save(existingProduct);
    }
}
