package br.com.vivo.desafio;

import java.net.URI;
import java.util.List;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vivo.desafio.dto.ProductsDto;
import br.com.vivo.desafio.dto.ProductsInput;
import br.com.vivo.desafio.dto.UpdateProductsInput;
import br.com.vivo.desafio.products.Products;
import br.com.vivo.desafio.repository.ProductsRepository;


@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRep;
	
	@GetMapping("/search")
	public List<Products> lista (String q, Double min_price , Double max_price) {
		if(q == null) {
		List<Products> products = productsRep.findAll();
		return (products);
	} else {
		List<Products> products = productsRep.findBysearch(q, min_price, max_price);
		return (products);
	}
  }
	
	@GetMapping
	public List<Products> lista () {
		List<Products> products = productsRep.findAll();
		return (products);
	}	
	
	

	@PostMapping
	public ResponseEntity<ProductsDto> cadastrar(@RequestBody @Valid ProductsInput input, UriComponentsBuilder uriBuilder) {
		Products products = input.convert();
		productsRep.save(products);
		
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(products.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductsDto(products));
}

	@GetMapping("/{id}")
	public ProductsDto detail(@PathVariable String id) {
		Products products = productsRep.getById(id);
		return new ProductsDto(products);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductsDto> update(@PathVariable String id, @RequestBody @Valid UpdateProductsInput input) {
		Products products = input.update(id, productsRep);
		
		return ResponseEntity.ok(new ProductsDto(products));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductsDto> delete(@PathVariable String id){
		productsRep.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

