package com.Springboot.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Springboot.dto.Product;

@Repository
public interface Productrepo extends JpaRepository<Product, Integer> {
	 Page<Product> findAll(Pageable pageable);
}
