package com.saline.naton.serviceimp;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saline.naton.entity.Product;
import com.saline.naton.repository.ProductRepository;
import com.saline.naton.service.ProductService;

@Service
public class ProductServiceimp implements ProductService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public Collection<Product> listProducts() {
		return (Collection<Product>) productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

}
