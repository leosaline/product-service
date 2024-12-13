package com.saline.naton.mapper;

import com.saline.naton.dto.ProductDTO;
import com.saline.naton.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ProductDTO toDto(Product product) {
        return new ProductDTO(product.getId(), product.getName(),
                product.getPackageType(),
                product.getCompany(),
                product.getCompanyName());
    }

    public Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.id(), productDTO.name(),
                productDTO.packageType(), productDTO.company(),
                productDTO.companyName());
    }
}