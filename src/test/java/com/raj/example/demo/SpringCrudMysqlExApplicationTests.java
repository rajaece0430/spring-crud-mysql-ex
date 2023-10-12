package com.raj.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.raj.example.demo.dto.ProductRequest;
import com.raj.example.demo.entity.Product;
import com.raj.example.demo.service.ProductService;


@SpringBootTest
class SpringCrudMysqlExApplicationTests {

	@Autowired
	private ProductService service;
	
	
	@Test	
	public void insertProductRecords() {
		ProductRequest request = new ProductRequest();
		request.setName("Phone");
		request.setDesc("iOS Phone 14");
		request.setPrice(20000);
		request.setQuantity(20);
		
		Product prod = service.saveProduct(request);
		
		assertEquals("Phone", prod.getName());
		
	}

}
