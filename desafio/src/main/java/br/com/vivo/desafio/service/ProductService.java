package br.com.vivo.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vivo.desafio.dto.ProductsDto;
import br.com.vivo.desafio.dto.ProductsInput;
import br.com.vivo.desafio.product.Product;
import br.com.vivo.desafio.repository.ProductRepository;


@Service
public class ProductService implements ProductServiceInterface{
	
	@Autowired
	private ProductRepository repository;

	public List<ProductsDto> findAll() {
		List<Product> lista = repository.findAll();
		return ProductsDto.converter(lista);
	}

		public ProductsDto getId(String id) {
		Product obj = repository.findById(id).orElse(null);
		if (obj == null) {
			return null;
		}
		return new ProductsDto(obj);
}
	@Transactional
	public ProductsDto create(ProductsInput product) {
		Product products = new Product(product);
		Product obj = repository.save(products);
		return new ProductsDto(obj);
	}

	@Transactional
	public ProductsDto update(String id, ProductsInput product) {
		Product products = repository.findById(id).orElse(null);
		if (products == null) {
			return null;
		}
		products.setDescription(product.getDescription());
		products.setName(product.getName());
		products.setPrice(product.getPrice());
		return new ProductsDto(products);
	}
	

	public Boolean deleteById(String id) {
		Product obj = repository.findById(id).orElse(null);
		if (obj == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}

	public List<ProductsDto> findBysearch(String q, Double min_price, Double max_price) {
		if(q != null) {
			q = q.toUpperCase();
		}
		List<Product> filtro = repository.findBysearch(q, min_price, max_price);
		return ProductsDto.converter(filtro);
	}



	}
