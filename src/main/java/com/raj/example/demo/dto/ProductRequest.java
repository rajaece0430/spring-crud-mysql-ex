package com.raj.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class ProductRequest {
	
	private String name;
	private String desc;
	private int quantity;
	private double price;
}
