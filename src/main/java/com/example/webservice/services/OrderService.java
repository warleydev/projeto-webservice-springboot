package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.entities.Order;
import com.example.webservice.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> order = repository.findById(id);
		return order.get();
	}
	
	public Order insert(Order order) {
		Order newOrder = repository.save(order);
		return newOrder;
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
