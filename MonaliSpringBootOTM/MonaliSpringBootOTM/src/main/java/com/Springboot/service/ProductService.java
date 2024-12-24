package com.Springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.dto.Product;
import com.Springboot.repository.Productrepo;
@Service
public class ProductService {
	     @Autowired
		 private Productrepo  productRepository;
		
		public List<Product> getAllProduct() {
			return productRepository.findAll();

		}
		 public Optional<Product> getProductById(int id) {
		        return productRepository.findById(id);
		    }
		public Product createProduct(Product product) {
		return productRepository.save(product);

		}
		public Product updateProduct(int id, Product updatedProduct)
		{
			Optional<Product> optional=productRepository.findById(id);
			if(optional.isPresent())
			{
				updatedProduct.setId(id);
				productRepository.save(updatedProduct);
				return updatedProduct;
			}
			return null;
		}
		public Product deleteProduct(int id)
		{
			Optional<Product> optional=productRepository.findById(id);
			if(optional.isPresent())
			{
				productRepository.deleteById(id);
				return optional.get();
			}
			return null;
		}
}
