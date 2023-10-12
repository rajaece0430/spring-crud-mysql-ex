package com.raj.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String desc;
	private int quantity;
	private double price;
	
	
}
