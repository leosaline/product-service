package com.saline.naton.serviceimp;

import com.google.gson.Gson;
import com.saline.naton.dto.CompanyDTO;
import com.saline.naton.dto.ProductDTO;
import com.saline.naton.entity.Product;
import com.saline.naton.exception.ProductNotFoundException;
import com.saline.naton.mapper.Mapper;
import com.saline.naton.repository.ProductRepository;
import com.saline.naton.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Value("${company.url}")
    private String companyURL;
    private Mapper mapper;

    @Override
    public Collection<ProductDTO> listProducts() {
        List<Product> listProduct = (List<Product>) productRepository.findAll();

        for (Product product : listProduct) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.getForEntity(companyURL + product.getCompany(), String.class);

                Gson gson = new Gson();
                CompanyDTO companyDTO = gson.fromJson(response.getBody(), CompanyDTO.class);
                product.setCompanyName((companyDTO == null) ? "Null" : companyDTO.getName());
            } catch (Exception e) {
                product.setCompanyName("NA");
            }
        }

        return listProduct.stream().map(p -> mapper.toDto(p)).toList();
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return mapper.toDto(productRepository.save(mapper.toProduct(productDTO)));
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return mapper.toDto(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public Iterable<ProductDTO> findAll() {
        return this.listProducts();
    }

}
