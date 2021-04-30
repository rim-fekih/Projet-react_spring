package com.example.demo.endpoints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modeles.ServiceEntity;
import com.example.demo.repositories.ServiceRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v3/")
public class ServiceController {
	@Autowired
	private ServiceRepository ServiceRepository;
	
	// get all employees
	@GetMapping("/service")
	public List<ServiceEntity> getAllService(){
		return ServiceRepository.findAll();
	}		
	
	// create service rest api
	@PostMapping("/service")
	public ServiceEntity createEmployee(@RequestBody ServiceEntity service) {
		return ServiceRepository.save(service);
	}
	
	// get service by id rest api
	@GetMapping("/service/{id}")
	public ResponseEntity<ServiceEntity> getServiceById(@PathVariable Long id) {
		ServiceEntity service = ServiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException.ResourceNotFoundException("Sevice not exist with id :" + id));
		return ResponseEntity.ok(service);
	}
	
	// update
	
	@PutMapping("/service/{id}")
	public ResponseEntity<ServiceEntity> updateService(@PathVariable Long id, @RequestBody ServiceEntity serviceDetails){
		ServiceEntity service = ServiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException.ResourceNotFoundException("Service not exist with id :" + id));
		
		service.setName(serviceDetails.getName());
		service.setDestination(serviceDetails.getDestination());
		service.setNombredeplace(serviceDetails.getNombredeplace());
		
		ServiceEntity updatedService = ServiceRepository.save(service);
		return ResponseEntity.ok(updatedService);
	}
	
	// delete
	@DeleteMapping("/service/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteService(@PathVariable Long id){
		ServiceEntity service = ServiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException.ResourceNotFoundException("Service not exist with id :" + id));
		
		ServiceRepository.delete(service);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
