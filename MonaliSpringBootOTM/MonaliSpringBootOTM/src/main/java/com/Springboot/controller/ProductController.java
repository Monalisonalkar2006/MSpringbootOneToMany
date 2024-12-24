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

import com.Springboot.dto.Product;
import com.Springboot.service.ProductService;
@RestController
@RequestMapping("/api")
public class ProductController {
	
	

		@Autowired
		ProductService productService;
		
		@GetMapping("/getAllProduct")
		public  List<Product> getAllProduct() {
		return productService.getAllProduct();

		}
		 @GetMapping("/Getid")
		  public Product getProductById(@PathVariable int id) {
		      return productService.getProductById(id).orElse(null);
		  }
	  @PostMapping("/createProduct")
	  @ResponseStatus(HttpStatus.CREATED)
		
	   public  Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);

	}	
		
		@PutMapping("/updateProduct") 
		public Product updateProduct(@RequestParam int id, @RequestBody Product product)
		{
			return productService.updateProduct(id, product);
		}
		
		
		@DeleteMapping("/deleteProduct")
		public void deleteProduct(@RequestParam int id)
		{
			productService.deleteProduct(id);
		}
}
