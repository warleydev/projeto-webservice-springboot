package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.webservice.entities.Product;
import com.example.webservice.repositories.ProductRepository;
import com.example.webservice.services.exceptions.DatabaseException;
import com.example.webservice.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id){
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Product insert(Product product){
		return repository.save(product);
	}
	
	public void deleteById(Long id){
		try {
	        if (repository.existsById(id)){
	            repository.deleteById(id);			
	        }
	        else{				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());
	    } 
	}
}
