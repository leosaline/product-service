package com.saline.naton.exception;

import com.saline.naton.entity.Product;

import java.util.function.Supplier;

public class ProductNotFoundException extends RuntimeException implements Supplier<Product> {

	public ProductNotFoundException() {
		super("Could not find product ");
	}

    @Override
    public Product get() {
        return null;
    }
}