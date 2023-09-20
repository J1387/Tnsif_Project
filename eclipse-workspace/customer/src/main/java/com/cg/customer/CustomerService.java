package com.cg.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	

	public List<Customer> listAll(){
		return repository.findAll();
	}
	
	public Customer get(Integer id) {
		return repository.findById(id).get();
	
	}
	
	
	public void save(Customer customer) {
		repository.save(customer);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}


	
