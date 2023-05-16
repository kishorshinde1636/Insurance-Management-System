package com.Insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.config.ResponseStructure;
import com.Insurance.dto.Client;
import com.Insurance.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping("/saveClient")
	public ResponseEntity<ResponseStructure<Client>> saveClient(@RequestBody Client client) {
		return service.saveClient(client);
	}

	@PutMapping("/updateClient")
	public ResponseEntity<ResponseStructure<Client>> updateClient(@RequestParam int id, @RequestBody Client client) {
		return service.updateClient(id, client);
	}

	@GetMapping("/getClienyById")
	public ResponseEntity<ResponseStructure<Client>> getClientById(@RequestParam int id) {
		return service.getClientById(id);
	}
	
	@DeleteMapping("/deleteClientById")
	public ResponseEntity<ResponseStructure<Client>> deleteClientById(@RequestParam int id)
	{
		return service.deleteClientById(id);
	}
	
	@GetMapping("/getAllClient")
	public ResponseEntity<ResponseStructure<Client>> getAllClient()
	{
		return service.getAllClient();
	}

}
