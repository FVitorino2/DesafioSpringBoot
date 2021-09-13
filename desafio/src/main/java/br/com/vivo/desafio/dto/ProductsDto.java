package br.com.vivo.desafio.dto;

import br.com.vivo.desafio.products.Products;

public class ProductsDto {

	private Long id;
	private String name;
	private String description;
	private double price;
	
	public ProductsDto(Products products) {
		this.id = products.getId();
		this.name = products.getName();
		this.description = products.getDescription();
		this.price = products.getPrice();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	
	
	
}
