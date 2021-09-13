package br.com.vivo.desafio.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.vivo.desafio.products.Products;
import br.com.vivo.desafio.repository.ProductsRepository;

public class UpdateProductsInput {
	
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

	public Products update(Long id, ProductsRepository productsrep) {
		Products products = productsrep.getOne(id);
		products.setName(this.name);
		products.setDescription(this.description);
		products.setPrice(this.price);
		
		return products;
		
	}
}
