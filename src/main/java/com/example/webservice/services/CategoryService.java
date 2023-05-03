package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.webservice.entities.Category;
import com.example.webservice.repositories.CategoryRepository;
import com.example.webservice.services.exceptions.DatabaseException;
import com.example.webservice.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id){
		Optional<Category> category = repository.findById(id);
		return category.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category category){
		Category newCategory = repository.save(category);
		return newCategory;
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
