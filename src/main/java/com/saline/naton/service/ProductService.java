package com.saline.naton.service;

import java.util.Collection;
import java.util.Optional;

import com.saline.naton.entity.Product;

public interface ProductService {
	public Collection<Product> listProducts();

	public Product save(Product product);

	public Optional<Product> getProductById(Long id);
	
	public Iterable<Product> findAll();
}
