package com.example.demo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modeles.BookingEntity;
import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;
import com.example.demo.services.CustomerService;



@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins="http://localhost:3000")
public class CustomerRest {
	private CustomerService service;
	
@Autowired
	public CustomerRest(CustomerService service) {
		super();
		this.service=service;
	
	}
@PostMapping
public CustomerEntity createPerson(@RequestBody CustomerEntity customer) {
	return service.createCustomerEntity(customer);
}
@PostMapping("/signin")
public String signin(@RequestBody CustomerEntity customer) {
	return service.SignIn(customer);
}
@GetMapping
public List<CustomerEntity> getAll() {
	return service.getAllCustomerEntities();
}
@GetMapping("/{id}")
public CustomerEntity getPersonById(@PathVariable("id") long id) {
	return service.getCustomerEntityById(id);
}

@PutMapping("/{id}")
public CustomerEntity updatePerson(@PathVariable("id") long id, @RequestBody CustomerEntity newcustomer) {
	return service.modifyCustomerEntity(id, newcustomer);
}
@DeleteMapping("/{id}")
public CustomerEntity deletePersonById(@PathVariable("id") long id) {
	return service.deleteCustomerEntityById(id);
}
@PostMapping("/{id}")
public BookingEntity createBooking(@RequestBody ServiceEntity serviceEntity,@PathVariable("id") long id) {
	CustomerEntity customer=new CustomerEntity();
	
	return service.createBookingEntity(serviceEntity,id);


	
}
}
