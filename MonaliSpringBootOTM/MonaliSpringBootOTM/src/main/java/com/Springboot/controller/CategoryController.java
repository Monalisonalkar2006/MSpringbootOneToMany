package com.Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.dto.Category;
import com.Springboot.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/getAllCategories")
	public  List<Category> getAllCategories() {
	return categoryService.getAllCategories();

	}
  @PostMapping("/createCategory")
  @ResponseStatus(HttpStatus.CREATED)
	
   public  Category createCategory(@RequestBody Category category) {
	return categoryService.createCategory(category);

}	
  @GetMapping("/Getid")
  public Category getCategoryById(@PathVariable int id) {
      return categoryService.getCategoryById(id).orElse(null);
  }
	@PutMapping("/updateCategory") 
	public Category updateCategory(@RequestParam int id, @RequestBody Category category)
	{
		return categoryService.updateCategory(id, category);
	}
	
	
	@DeleteMapping("/deleteCategory")
	public void deleteCategory(@RequestParam int id)
	{
		categoryService.deleteCategory(id);
	}
  
}
