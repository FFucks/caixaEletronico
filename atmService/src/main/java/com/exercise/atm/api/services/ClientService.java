package com.exercise.atm.api.services;

import java.util.List;
import java.util.Optional;

import com.exercise.atm.api.documents.Client;

public interface ClientService {
	
	List<Client> getAllClients();
	
	Optional<Client> getClientById(String id);
	
	Client add(Client client);
	
	Client update(Client client);
	
	void remove(String id);
	
}
