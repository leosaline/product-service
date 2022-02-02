package com.saline.naton.controller;

import com.saline.naton.dto.ProductDTO;
import com.saline.naton.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<Collection<ProductDTO>> findAll() {
        return ResponseEntity.ok((Collection<ProductDTO>) this.productService.findAll());
    }

    @PostMapping(value = "/product", produces = "application/json")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.save(productDTO));
    }

    @GetMapping(value = "/product/{id}", produces = "application/json")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
