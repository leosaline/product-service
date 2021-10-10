package com.saline.naton.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saline.exception.ProductNotFoundException;
import com.saline.naton.entity.Product;
import com.saline.naton.service.ProductService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of products") })
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<Collection<Product>> findAll() {
		return ResponseEntity.ok((Collection<Product>) this.productService.findAll());
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Create a new product") })
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(value = "/product", produces = "application/json")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return a single product") })
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/product/{id}", produces = "application/json")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
		return ResponseEntity.ok(product);
	}
}
