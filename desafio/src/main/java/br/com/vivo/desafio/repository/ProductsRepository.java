package br.com.vivo.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.desafio.products.*;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

	List<Products> findByname(String name);

}
