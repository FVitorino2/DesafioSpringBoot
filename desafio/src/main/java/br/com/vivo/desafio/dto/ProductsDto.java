package br.com.vivo.desafio.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vivo.desafio.product.Product;

public class ProductsDto {

	private String id;
	private String name;
	private String description;
	private Double price;
	
	public ProductsDto(Product products) {
		this.id = products.getId();
		this.name = products.getName();
		this.description = products.getDescription();
		this.price = products.getPrice();
	}
	
	public ProductsDto(ProductsDto products) {
		
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Double getPrice() {
		return price;
	}
	
	public static List<ProductsDto> converter(List<Product> lista) {
		return lista.stream().map(ProductsDto::new).collect(Collectors.toList());
	}
	
	
}
