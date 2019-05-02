package com.exercise.atm.api.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.atm.api.documents.Client;
import com.exercise.atm.api.repositories.ClientRepository;
import com.exercise.atm.api.services.ClientService;


@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> getAllClients() {
		return this.clientRepository.findAll();
	}

	@Override
	public Optional<Client> getClientById(String id) {
		return this.clientRepository.findById(id);
	}

	@Override
	public Client add(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public void remove(String id) {
		this.clientRepository.deleteById(id);
	}
}
