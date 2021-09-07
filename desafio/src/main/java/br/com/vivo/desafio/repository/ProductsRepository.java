package br.com.vivo.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.desafio.products.*;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}
