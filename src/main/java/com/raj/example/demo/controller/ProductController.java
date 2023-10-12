package com.raj.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raj.example.demo.dto.ProductRequest;
import com.raj.example.demo.entity.Product;
import com.raj.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	public ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productReq) {
		return ResponseEntity.ok(service.saveProduct(productReq));
	}
	
	@PostMapping("/addProducts")
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<ProductRequest> productsReq) {
		return ResponseEntity.ok(service.saveProducts(productsReq));
	}
	
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
	
	@GetMapping("/productByName/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody ProductRequest productReq) {
		return service.saveProduct(productReq);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
