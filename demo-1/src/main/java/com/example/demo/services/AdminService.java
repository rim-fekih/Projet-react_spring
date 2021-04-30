package com.example.demo.services;

import java.util.List;

import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;

public interface AdminService {
	List<CustomerEntity> getAllCustomer();
	List<ServiceEntity> getAllServices();
}
