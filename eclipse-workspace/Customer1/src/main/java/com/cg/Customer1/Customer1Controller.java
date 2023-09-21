package com.cg.Customer1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Customer1Controller {
	
	@Autowired
	private Customer1Service service;

	//Retrieval
	@GetMapping("/customers")
	public List<Customer1> list()
	 {
	 return service.listAll();
	 }
	
	//Retrieve By id
	@GetMapping("/customers/{id}")
        public ResponseEntity <Customer1> get(@PathVariable Integer id){
		try {
			Customer1 customer = service.get(id);
			return new ResponseEntity <Customer1> (customer, HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity <Customer1> (HttpStatus.NOT_FOUND);
		}
		}
	
	//Create
	@PostMapping("/customers")
	public void add(@RequestBody Customer1 customer) {
		service.save(customer);
	}
	
	//update
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer1 customer, @PathVariable Integer id){
		
		try {
			Customer1 existCustomer = service.get(id);
			service.save(existCustomer);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch(Exception e) {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
}
	//Delete
	@DeleteMapping("/customers/{id}")
	public void delete (@PathVariable Integer id) {
		service.delete(id);
		
	}
	
}



