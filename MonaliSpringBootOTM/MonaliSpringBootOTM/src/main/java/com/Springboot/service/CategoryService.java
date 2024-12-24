package com.Springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.dto.Category;
import com.Springboot.repository.Categoryrepo;

@Service
public class CategoryService {


	
	@Autowired
	 private Categoryrepo  categoryRepository;
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();

	}
	 public Optional<Category> getCategoryById(int id) {
	        return categoryRepository.findById(id);
	    }
	public Category createCategory(Category category) {
	return categoryRepository.save(category);

	}
	
	public Category updateCategory(int id, Category updatedCategory)
	{
		Optional<Category> optional=categoryRepository.findById(id);
		if(optional.isPresent())
		{
			updatedCategory.setId(id);
			categoryRepository.save(updatedCategory);
			return updatedCategory;
		}
		return null;
	}
	public Category deleteCategory(int id)
	{
		Optional<Category> optional=categoryRepository.findById(id);
		if(optional.isPresent())
		{
			categoryRepository.deleteById(id);
			return optional.get();
		}
		return null;
	}


	
}
