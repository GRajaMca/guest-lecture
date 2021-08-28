package com.javabeans.io.productcatalog.controllers;

import com.javabeans.io.productcatalog.models.ProductDTO;
import com.javabeans.io.productcatalog.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping(value = "{id}")
    public Optional<ProductDTO> getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.saveProduct(productDTO);
    }

    @DeleteMapping(value = "{id}")
    public String deleteProduct(@PathVariable Long id) {
        try {
            this.productService.deleteProductById(id);
            return "Deleted successfully :)";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failed";
    }

    @PutMapping(value = "{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) throws Exception {
        return this.productService.updateProduct(productDTO, id);
    }

}
