package com.raj.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.example.demo.dto.ProductRequest;
import com.raj.example.demo.entity.Product;
import com.raj.example.demo.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product saveProduct(ProductRequest productReq) {
		Product product = Product.build(0, productReq.getName(), productReq.getDesc(), productReq.getQuantity(), productReq.getPrice());
		return productRepo.save(product);
	}

	public List<Product> saveProducts(List<ProductRequest> productsReq) {
		List<Product> products = productsReq.stream()
				.map(prouct -> Product.build(0, prouct.getName(), prouct.getDesc(), prouct.getQuantity(), prouct.getPrice()))
				.collect(Collectors.toList());
		
		return productRepo.saveAll(products);
	}

	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public Product getProduct(int id) {
		return productRepo.findById(id).orElse(null);
	}

	public List<Product> getProductByName(String name) {
		return productRepo.findByName(name);
	}

	public String deleteProduct(int id) {
		productRepo.deleteById(id);

		return "Product removed with id : " + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productRepo.findById(product.getId()).orElse(null);

		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setDesc(product.getDesc());
			productRepo.save(existingProduct);
		}

		return existingProduct;

	}
}
