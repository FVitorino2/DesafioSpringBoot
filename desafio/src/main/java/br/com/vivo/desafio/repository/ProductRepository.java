package br.com.vivo.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vivo.desafio.product.*;

@Repository
@RestControllerAdvice
public interface ProductRepository extends JpaRepository<Product, String>{
	
	
	@Query("select u from Product u where (:q is null or UPPER(u.name) like %:q% or UPPER(u.description) like %:q%) and (:min_price is null or u.price >= :min_price) and (:max_price is null or u.price <= :max_price)") 
	List<Product> findBysearch(@Param("q") String q, @Param("min_price") Double min_price, @Param("max_price") Double max_price);

}
