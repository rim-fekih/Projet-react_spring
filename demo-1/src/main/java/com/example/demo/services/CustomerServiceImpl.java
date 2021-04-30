package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modeles.BookingEntity;
import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;
import com.example.demo.repositories.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository repos;
	@Override
	public CustomerEntity createCustomerEntity(CustomerEntity customer) {

		
		return repos.save(customer);
	}
	public CustomerServiceImpl(CustomerRepository repos) {
		super();
		this.repos=repos;
		
}
	@Override
	public String SignIn(CustomerEntity customer) {
		Optional<CustomerEntity> opt=repos.findByEmail(customer.getEmail());
		if(opt.isPresent()) {
			CustomerEntity cus=opt.get();
			if(cus.getPassword().equals(customer.getPassword())){
				return "actif";
			}
			

		}
		return "email ou mdp incorrecte" ;
	}
	@Override
	public List<CustomerEntity> getAllCustomerEntities() {
	
		return repos.findAll();
	}

public CustomerEntity getCustomerEntityById(long id) {
	CustomerEntity entity;
	Optional<CustomerEntity> opt = repos.findById(id);
	if(opt.isPresent())
		entity=opt.get();
else
		throw new NoSuchElementException("customer with this id is not found");
	
	return entity;
		
	}
	
	@Override
	public CustomerEntity modifyCustomerEntity(long id, CustomerEntity customer) {
		CustomerEntity oldCustomer=this.getCustomerEntityById(id);
		if(customer.getNom() !=null)
			oldCustomer.setNom(customer.getNom());
		if(customer.getAddress() !=null)
			oldCustomer.setAddress(customer.getAddress());
		if(customer.getEmail() !=null)
			oldCustomer.setEmail(customer.getEmail());
		if(customer.getPassword() !=null)
			oldCustomer.setPassword(customer.getPassword());
		if(customer.getPrenom() !=null)
			oldCustomer.setPrenom(customer.getPrenom());
		if(customer.getId() !=0)
			oldCustomer.setId(customer.getId());	
		return repos.save(oldCustomer);
	}
	@Override
	public CustomerEntity deleteCustomerEntityById(long id) {
		CustomerEntity entity = this.getCustomerEntityById(id);
		repos.deleteById(id);
		return entity;
		
	}
	@Override
	public BookingEntity createBookingEntity(ServiceEntity service ,long id) {
		CustomerEntity entity;
		Optional<CustomerEntity> opt = repos.findById(id);
		if(opt.isPresent())
			entity=opt.get();
		else
			throw new NoSuchElementException("customer with this id is not found");
	
		if(service.getNombredeplace() !=0)
			service.setNombredeplace(service.getNombredeplace()-1);
	    BookingEntity booking=new BookingEntity();
	    booking.setDate(LocalDate.now());
	
	booking.setStatus(true);
	entity.getBookings().add(booking);
		return booking;
	}
	
}
