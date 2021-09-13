package br.com.vivo.desafio.dto;

import br.com.vivo.desafio.products.Products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductsInput {

	@NotNull @NotEmpty 
	private String name;
	@NotNull @NotEmpty
	private String description;
	@NotNull @Min(0)
	private double price;
			
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Products convert() {
		return new Products(name, description, price);
	}
	
	
}
