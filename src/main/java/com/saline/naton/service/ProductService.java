package com.saline.naton.service;

import com.saline.naton.dto.ProductDTO;

import java.util.Collection;

public interface ProductService {
    Collection<ProductDTO> listProducts();

    ProductDTO save(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    Iterable<ProductDTO> findAll();
}
