package com.saline.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1833211873580585132L;

	public ProductNotFoundException(Long id) {
		super("Could not find product " + id);
	}
}