package com.example.demo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;
import com.example.demo.services.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminRest {
	private AdminService service;
	@Autowired
	public 	AdminRest(AdminService service) {
		super();
		this.service=service;
	
	}
	@GetMapping("/getallcustomer")
	public List<CustomerEntity> getAllcustomer() {
		return service.getAllCustomer();
	}
	@GetMapping("/getallservices")
	public List<ServiceEntity> getAllservice() {
		return service.getAllServices();
	}
}
