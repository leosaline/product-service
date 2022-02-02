package com.saline.naton.service;

import com.saline.naton.dto.ProductDTO;

import java.util.Collection;

public interface ProductService {
    public Collection<ProductDTO> listProducts();

    public ProductDTO save(ProductDTO productDTO);

    public ProductDTO getProductById(Long id);

    public Iterable<ProductDTO> findAll();
}
