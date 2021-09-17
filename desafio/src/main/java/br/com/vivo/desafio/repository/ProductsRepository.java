package br.com.vivo.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vivo.desafio.products.*;

@Repository
@RestControllerAdvice
public interface ProductsRepository extends JpaRepository<Products, String>{
	
	
	@Query("select u from Products u where (:q is null or u.name like %:q% or u.description like %:q%) and (:min_price is null or u.price >= :min_price) and (:max_price is null or u.price <= :max_price)") 
	List<Products> findBysearch(@Param("q") String q, @Param("min_price") Double min_price, @Param("max_price") Double max_price);
}
