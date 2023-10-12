package com.raj.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);
		

}
