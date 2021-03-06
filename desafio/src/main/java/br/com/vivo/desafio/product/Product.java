package br.com.vivo.desafio.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vivo.desafio.dto.ProductsInput;

@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String description;
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}

	public Product(String id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Product(ProductsInput product) {
		super();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}
	
	public Product() {
		
	}
	
	}
	
	
	

