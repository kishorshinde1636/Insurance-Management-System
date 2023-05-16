package com.Insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Insurance.config.ResponseStructure;
import com.Insurance.dao.ClientDao;
import com.Insurance.dto.Client;
import com.Insurance.exception.ClientNotFoundByIdException;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client client) {
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("client save");
		responseStructure.setData(clientDao.saveClinet(client));
		return new ResponseEntity<ResponseStructure<Client>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Client>> updateClient(int id, Client client) {

		Client client2 = clientDao.updateClient(id, client);
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();

		if (client2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage(" update client ");
			responseStructure.setData(client);
			return new ResponseEntity<ResponseStructure<Client>>(responseStructure, HttpStatus.OK);

		} else {
			throw new ClientNotFoundByIdException("Failed to Find Id");
		}
	}

	public ResponseEntity<ResponseStructure<Client>> getClientById(int id) {
		Client client = clientDao.getClientById(id);
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();

		if (client != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("get client By Id ");
			responseStructure.setData(client);
			return new ResponseEntity<ResponseStructure<Client>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ClientNotFoundByIdException("Failed to Find Id");
		}
	}

	public ResponseEntity<ResponseStructure<Client>> deleteClientById(int id) {
		Client client = clientDao.deleteClientById(id);
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();

		if (client != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Delete client ");
			responseStructure.setData(client);
			return new ResponseEntity<ResponseStructure<Client>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ClientNotFoundByIdException("Failed to Find Id");
		}
	}

	public ResponseEntity<ResponseStructure<Client>> getAllClient() {
		ResponseStructure<Client> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Get All client");
		responseStructure.setData(clientDao.getAllClient());
		return new ResponseEntity<ResponseStructure<Client>>(responseStructure, HttpStatus.FOUND);
	}

}
