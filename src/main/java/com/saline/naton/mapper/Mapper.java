package com.saline.naton.mapper;

import com.saline.naton.dto.ProductDTO;
import com.saline.naton.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ProductDTO toDto(Product product) {
        return new ProductDTO.ProductDTOBuilder(product.getId(), product.getName())
                .withPackageTypeEnum(product.getPackageType())
                .withCompanyName(product.getCompanyName())
                .withCompany(product.getCompany())
                .build();
    }

    public Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(),
                productDTO.getPackageType(), productDTO.getCompany(),
                productDTO.getCompanyName());
    }
}