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

import com.example.demo.modeles.Client;
import com.example.demo.modeles.Employee;
import com.example.demo.repositories.ClientRepository ;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v2/")
public class ClientController {

	@Autowired
	private ClientRepository ClientRepository;
	
	// get all Client
	@GetMapping("/client")
	public List<Client> getAllClient(){
		return ClientRepository.findAll();
	}		
	
	// create client rest api
	@PostMapping("/client")
	public Client createClient(@RequestBody Client client) {
		return ClientRepository.save(client);
	}
	
	// get client by id rest api
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		Client client = ClientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException.ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(client);
	}
	
	// update employee rest api
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
	 Client client = ClientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException.ResourceNotFoundException("Client not exist with id :" + id));
		
		client.setFirstName(clientDetails.getFirstName());
		client.setLastName(clientDetails.getLastName());
		client.setEmailId(clientDetails.getEmailId());
		
		Client updatedClient = ClientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}
	
	// delete client rest api
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
		Client client = ClientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException.ResourceNotFoundException("Client not exist with id :" + id));
		
		ClientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

