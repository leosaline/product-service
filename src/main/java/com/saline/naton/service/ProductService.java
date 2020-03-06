package com.saline.naton.service;

import java.util.Collection;

import com.saline.naton.entity.Product;

public interface ProductService {
	public Collection<Product> listProducts();
	public Product save(Product product);
	public Product getProductById(Long id);

}
