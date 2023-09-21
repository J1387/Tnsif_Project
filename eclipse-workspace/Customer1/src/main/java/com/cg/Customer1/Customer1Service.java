package com.cg.Customer1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Customer1Service {
	@Autowired
	private Customer1Repository repository;
	

	public List<Customer1> listAll(){
		return repository.findAll();
	}
	
	public Customer1 get(Integer id) {
		return repository.findById(id).get();
	
	}
	
	
	public void save(Customer1 customer) {
		repository.save(customer);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}

	


