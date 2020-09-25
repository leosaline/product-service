package com.saline.naton.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.saline.naton.controller.ProductController;
import com.saline.naton.entity.Product;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

	@Override
	public EntityModel<Product> toModel(Product product) {
		return EntityModel.of(product,
				linkTo(methodOn(ProductController.class).getProductById(product.getId())).withSelfRel(),
				linkTo(methodOn(ProductController.class).findAll()).withRel("products"));
	}
}
