package com.saline.naton.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saline.naton.entity.Product;
import com.saline.naton.service.ProductService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of products") })
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Collection<Product>> listProducts() {
		return ResponseEntity.ok(this.productService.listProducts());
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return a new product") })
	@RequestMapping(value = "/product", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.save(product));
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return a single product") })
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
}
