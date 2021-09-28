package br.com.vivo.desafio.dto;

import br.com.vivo.desafio.product.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductsInput {

	@NotNull @NotEmpty 
	private String name;
	@NotNull @NotEmpty
	private String description;
	@NotNull @Min(1)
	private Double price;
			
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Double getPrice() {
		return price;
	}

	public ProductsInput(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}
		
	public ProductsInput() {

	}
	
}
