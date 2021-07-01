package com.saline.naton.serviceimp;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.saline.naton.dto.CompanyDTO;
import com.saline.naton.entity.Product;
import com.saline.naton.repository.ProductRepository;
import com.saline.naton.service.ProductService;

@Service
public class ProductServiceimp implements ProductService {
	@Autowired
	ProductRepository productRepository;
	@Value("${company.url}")
	private String companyURL;

	@Override
	public Collection<Product> listProducts() {
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

		return listProduct;
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Iterable<Product> findAll() {
		return this.listProducts();
	}

}
