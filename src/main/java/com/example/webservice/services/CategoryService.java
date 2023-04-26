package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.entities.Category;
import com.example.webservice.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id){
		Optional<Category> category = repository.findById(id);
		return category.get();
	}
	
	public Category insert(Category category){
		Category newCategory = repository.save(category);
		return newCategory;
	}
	
	public void deleteById(Long id){
		repository.deleteById(id);
	}
}