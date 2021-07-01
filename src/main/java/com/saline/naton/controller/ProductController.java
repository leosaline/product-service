package com.saline.naton.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saline.exception.ProductNotFoundException;
import com.saline.naton.assembler.ProductModelAssembler;
import com.saline.naton.entity.Product;
import com.saline.naton.service.ProductService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

	private final ProductService productService;

	private final ProductModelAssembler assembler;

	public ProductController(ProductService productService, ProductModelAssembler assembler) {
		this.productService = productService;
		this.assembler = assembler;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of products") })
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/products", produces = "application/json")
	public CollectionModel<EntityModel<Product>> findAll() {
		List<EntityModel<Product>> products = StreamSupport.stream(productService.findAll().spliterator(), false)
				.map(assembler::toModel).collect(Collectors.toList());

		return CollectionModel.of(products, linkTo(methodOn(ProductController.class).findAll()).withSelfRel());
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Create a new product") })
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(value = "/product", produces = "application/json")
	public EntityModel<Product> createProduct(@RequestBody Product product) {
		return assembler.toModel(productService.save(product));
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return a single product") })
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/product/{id}", produces = "application/json")
	public EntityModel<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
		return assembler.toModel(product);
	}
}
