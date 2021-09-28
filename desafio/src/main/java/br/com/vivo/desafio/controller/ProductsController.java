package br.com.vivo.desafio.controller;

import java.util.List;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.desafio.dto.ProductsDto;
import br.com.vivo.desafio.dto.ProductsInput;
import br.com.vivo.desafio.service.ProductServiceInterface;


@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductServiceInterface productService;
	
	
	@GetMapping
	public ResponseEntity<List<ProductsDto>> findAll() {
		List<ProductsDto> lista = productService.findAll();
		return ResponseEntity.ok(lista);
	}	
	
	@PostMapping
	public ResponseEntity<ProductsDto> create(@RequestBody @Valid ProductsInput product) {
		ProductsDto products = productService.create(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(products);
}

	@GetMapping("/{id}")
	public ResponseEntity<ProductsDto> getId(@PathVariable String id) {
		ProductsDto products = productService.getId(id);
		if(products == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(products);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductsDto> update(@PathVariable String id, @Valid @RequestBody ProductsInput input) {
		ProductsDto products = productService.update(id, input);
		if (products == null ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductsDto> delete(@PathVariable String id){
		if (productService.deleteById(id)) {
		return ResponseEntity.ok().build();
	}
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<ProductsDto>> findBysearch(@RequestParam(required = false) String q, @RequestParam(required = false) Double min_price , @RequestParam(required = false) Double max_price) {
		List<ProductsDto> products = productService.findBysearch(q, min_price, max_price);
		return ResponseEntity.ok(products);
  }
}

