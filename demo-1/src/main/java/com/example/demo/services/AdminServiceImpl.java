package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ServiceRepository;
@Service
public class AdminServiceImpl implements AdminService {
	private CustomerRepository repos;
	private ServiceRepository reposservice;
	public AdminServiceImpl(CustomerRepository repos,ServiceRepository reposservice) {
		super();
		this.repos=repos;
		this.reposservice=reposservice;
		
}
	@Override
	public List<CustomerEntity> getAllCustomer() {
	
		return repos.findAll();
	}
	@Override
	public List<ServiceEntity> getAllServices() {
		// TODO Auto-generated method stub
		return reposservice.findAll();
	}

}
