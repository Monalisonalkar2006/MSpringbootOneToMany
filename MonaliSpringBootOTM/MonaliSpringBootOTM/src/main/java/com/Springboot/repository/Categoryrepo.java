package com.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.dto.Category;

@Repository
public interface Categoryrepo extends JpaRepository<Category, Integer> {

}
