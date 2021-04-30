package com.example.demo.services;

import java.util.List;

import com.example.demo.modeles.BookingEntity;
import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;

public interface CustomerService {
	CustomerEntity createCustomerEntity(CustomerEntity customer);
	List<CustomerEntity> getAllCustomerEntities();
	CustomerEntity modifyCustomerEntity(long id, CustomerEntity customer);
	String SignIn(CustomerEntity customer);
	CustomerEntity getCustomerEntityById(long id);
	CustomerEntity deleteCustomerEntityById(long id);
	
	BookingEntity createBookingEntity(ServiceEntity Service, long ids);

}
