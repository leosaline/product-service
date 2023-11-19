package com.saline.naton.controller;

import com.saline.naton.dto.ProductDTO;
import com.saline.naton.exception.ProductNotFoundException;
import com.saline.naton.service.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Collections;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;


@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController productController;

    @InjectMocks
    private ProductNotFoundException productNotFoundException;


    @Before
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(new ProductController(service));
    }

    @Test
    public void ShouldReturnAllProducts() {
        when(service.listProducts()).thenReturn(Collections.emptyList());

        given()
                .when()
                .get("/products")
                .then()
                .log().ifValidationFails()
                .statusCode(OK.value())
                .contentType(JSON)
                .body(is(equalTo("[]")));
    }

    @Test
    public void ShouldCreateNewProduct() {
        ProductDTO product = new ProductDTO.ProductDTOBuilder(1L, "shampoo")
                .withCompanyName("avon")
                .build();
        JSONObject json = new JSONObject();
        try {
            json.put("id", "1");
            json.put("name", "shampoo");
            json.put("company", "avon");
        } catch (JSONException e) {
        }

        when(service.save(product)).thenReturn(product);

        with().body(json.toString())
                .when()
                .request("POST", "/product")
                .then()
                .statusCode(201);
    }

    @Test
    public void ShouldGetProductById() {

    }

    @Test
    public void ShouldThrowWhenProductNoFound() {

    }

}
