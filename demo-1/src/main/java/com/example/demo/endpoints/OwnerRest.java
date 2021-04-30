package com.example.demo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.OwnerEntity;
import com.example.demo.modeles.ServiceEntity;
import com.example.demo.services.OwnerService;

@RestController
@RequestMapping("/api/Owner")
public class OwnerRest {
	private OwnerService services;
	@Autowired
public OwnerRest(OwnerService services) {
			super();
			this.services=services;
		
		}
	@PostMapping
	public OwnerEntity createOwner(@RequestBody OwnerEntity Owner) {
		return services.createOwnerEntity(Owner);
	}
	@DeleteMapping("/{id}")
	public OwnerEntity deletePersonById(@PathVariable("id") long id) {
		return services.deleteOwnerEntityById(id);
	}
	@PostMapping("/Service")
	public ServiceEntity createService(@RequestBody ServiceEntity Service) {
		return services.createServiceEntity(Service);
	}
	@DeleteMapping("/Service/{id}")
	public ServiceEntity deleteServiceById(@PathVariable("id") long id) {
		return services.deleteServiceEntityById(id);
	}
	@PutMapping("/Service/update/{id}")
	public ServiceEntity updateService(@PathVariable("id") long id, @RequestBody ServiceEntity newservice) {
		return services.modifyServiceEntity(id, newservice);
	}
	
	@GetMapping("/Service/getAll")
	public List<ServiceEntity> getAll() {
		return services.getAllServicesEntities();
	}
}
