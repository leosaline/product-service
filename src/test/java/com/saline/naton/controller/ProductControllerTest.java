package com.saline.naton.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.saline.naton.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService service;

//	@MockBean
//	private ProductModelAssembler assembler;
//
//	@Test
//	public void testFindAll() throws Exception {
//		Product product_one = new Product();
//		Product product_two = new Product();
//		Product product_tree = new Product();
//
//		product_one.setName("product one");
//		product_two.setName("product two");
//		product_tree.setName("product tree");
//		ProductModelAssembler asb = new ProductModelAssembler();
//
//		List<Product> allproducts = Arrays.asList(product_one, product_two, product_tree);
//
//		given(service.findAll()).willReturn(allproducts);
//		given(assembler.toModel(product_one)).willReturn(asb.toModel(product_one));
//		given(assembler.toModel(product_two)).willReturn(asb.toModel(product_two));
//		given(assembler.toModel(product_tree)).willReturn(asb.toModel(product_tree));
//
//		ResultActions result = mvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//		result.andDo(print());
//		result.andExpect(jsonPath("_embedded.productList[0].name", is(product_one.getName())));
//		result.andExpect(jsonPath("_embedded.productList[1].name", is(product_two.getName())));
//		result.andExpect(jsonPath("_embedded.productList[2].name", is(product_tree.getName())));
//
//		verify(service, VerificationModeFactory.times(1)).findAll();
//		reset(service);
//	}
//
//	@Test
//	public void testCreateProduct() throws Exception {
//		ProductModelAssembler asb = new ProductModelAssembler();
//		Product product = new Product();
//		product.setId(1L);
//		product.setName("produto");
//		product.setCompany(1L);
//		product.setPackageType(PackageTypeEnum.BAR);
//
//		given(service.save(Mockito.any())).willReturn(product);
//		given(assembler.toModel(product)).willReturn(asb.toModel(product));
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		ResultActions result = mvc.perform(
//				post("/product").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(product)));
//		result.andDo(print());
//		result.andExpect(status().isOk());
//		result.andExpect(jsonPath("$.name", is("produto")));
//
//		verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
//		reset(service);
//	}
//
//	@Test
//	public void testGetProductById() throws Exception {
//		ProductModelAssembler asb = new ProductModelAssembler();
//		Optional<Product> product = Optional.of(new Product());
//		product.get().setId(1L);
//		product.get().setName("produto");
//		product.get().setCompany(1L);
//		product.get().setPackageType(PackageTypeEnum.BAR);
//
//		given(service.getProductById(product.get().getId())).willReturn(product);
//		given(assembler.toModel(product.get())).willReturn(asb.toModel(product.get()));
//
//		ResultActions result = mvc
//				.perform(get("/product/" + product.get().getId()).contentType(MediaType.APPLICATION_JSON));
//		result.andDo(print());
//		result.andExpect(status().isOk());
//		result.andExpect(jsonPath("$.name", is(product.get().getName())));
//
//		verify(service, VerificationModeFactory.times(1)).getProductById(Mockito.any());
//		reset(service);
//	}
//
//	@Test(expected = ProductNotFoundException.class)
//	public void testGetProductById_throwException() throws Exception {
//		ProductModelAssembler asb = new ProductModelAssembler();
//		Optional<Product> product = Optional.of(new Product());
//		product.get().setId(1L);
//		product.get().setName("produto");
//		product.get().setCompany(1L);
//		product.get().setPackageType(PackageTypeEnum.BAR);
//
//		given(service.getProductById(product.get().getId())).willThrow(ProductNotFoundException.class);
//		given(assembler.toModel(product.get())).willReturn(asb.toModel(product.get()));
//
//		ResultActions result = mvc
//				.perform(get("/product/" + product.get().getId()).contentType(MediaType.APPLICATION_JSON));
//		result.andExpect(status().is4xxClientError());
//
//		MvcResult mvnResult = result.andReturn();
//		Optional<Exception> optException = Optional.ofNullable(mvnResult.getResolvedException());
//
//		if (optException.isPresent()) {
//			throw new ProductNotFoundException(1L);
//		}
//
//		reset(service);
//	}

}
