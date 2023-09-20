package com.cg.Customer2;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class Customer2Service {
	
	@Autowired
	private Customer2Repository repository;
	

	public List<Customer2> listAll(){
		return repository.findAll();
	}
	
	public Customer2 get(Integer id) {
		return repository.findById(id).get();
	
	}
	
	
	public void save(Customer2 customer) {
		repository.save(customer);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	

}
