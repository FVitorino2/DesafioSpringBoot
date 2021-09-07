package br.com.vivo.desafio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.desafio.products.Products;
import br.com.vivo.desafio.repository.ProductsRepository;


@RestController
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepo;
	 
	@RequestMapping("/products")
	public List<Products> lista () {
		List<Products> products = productsRepo.findAll();
		return (products);
	}

}
