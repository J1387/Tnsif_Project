package com.cg.Customer2;

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

public class Customer2Controller {
	
	@Autowired
	private Customer2Service service;

	//Retrieval
	@GetMapping("/customers")
	public List<Customer2> list()
	 {
	 return service.listAll();
	 }
	
	//Retrieve By id
	@GetMapping("/customers/{id}")
        public ResponseEntity <Customer2> get(@PathVariable Integer id){
		try {
			Customer2 customer = service.get(id);
			return new ResponseEntity <Customer2> (customer, HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity <Customer2> (HttpStatus.NOT_FOUND);
		}
		}
	
	//Create
	@PostMapping("/customers")
	public void add(@RequestBody Customer2 customer) {
		service.save(customer);
	}
	
	//update
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer2 customer, @PathVariable Integer id){
		
		try {
			Customer2 existCustomer = service.get(id);
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
