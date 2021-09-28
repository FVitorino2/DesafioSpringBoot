package br.com.vivo.desafio.service;

import java.util.List;

import br.com.vivo.desafio.dto.ProductsDto;
import br.com.vivo.desafio.dto.ProductsInput;

public interface ProductServiceInterface {

	public List<ProductsDto> findAll();
	public ProductsDto getId(String id);
	public ProductsDto create(ProductsInput product);
	public ProductsDto update(String id, ProductsInput product);
	public Boolean deleteById(String id);
	public List<ProductsDto> findBysearch(String q, Double min_price, Double max_price);
	
}
