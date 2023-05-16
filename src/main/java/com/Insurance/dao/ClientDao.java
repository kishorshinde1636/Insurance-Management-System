package com.Insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Insurance.dto.Client;
import com.Insurance.repo.ClientRepo;

@Repository
public class ClientDao {

	@Autowired
	private ClientRepo repo;

	public Client saveClinet(Client client) {
		return repo.save(client);
	}

	public Client updateClient(int id, Client client) {

		Optional<Client> client2 = repo.findById(id);

		if (client2.isPresent()) {
			client.setId(id);
			repo.save(client);
			return client2.get();
		} else {
			return null;
		}

	}
	
	public Client getClientById(int id)
	{
		Optional<Client> client=repo.findById(id);
		
		if(client.isPresent())
		{
			return client.get();
		}
		else {
			return null;
		}
	}
	
	
	public Client deleteClientById(int id)
	{
	 Optional<Client> client=repo.findById(id);
	 
	 if(client.isEmpty())
	 {
		 return null;
	 }
	 else {
		repo.deleteById(id);
		return client.get();
	}
	 
	}
	
	public List<Client> getAllClient()
	{
	  List<Client> client=repo.findAll();
	   return client;
	}
	

}
