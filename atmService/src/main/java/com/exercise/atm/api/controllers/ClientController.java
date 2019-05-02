package com.exercise.atm.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.exercise.atm.api.documents.BankNotes;
import com.exercise.atm.api.documents.Client;
import com.exercise.atm.api.services.ClientService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/clients")
public class ClientController { 
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> listAll() {
		return ResponseEntity.ok(this.clientService.getAllClients());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Client>> listById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.clientService.getClientById(id));
	}
	
	
	@PostMapping
	public ResponseEntity<Client> add(@Valid @RequestBody Client client) {
		return ResponseEntity.ok(this.clientService.add(client));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Client> update(@Valid @PathVariable(name = "id") String id, @RequestBody Client client) {
		client.setId(id);
		client.setBankNotes(new BankNotes());
		notesCalculation(client);
		return ResponseEntity.ok(this.clientService.update(client));
	}
	
	@DeleteMapping(path = "/{id}")
	public void remove(@PathVariable(name = "id") String id){
		this.clientService.remove(id);
	}
	
	private void notesCalculation(Client client) {
		int cashValue = client.getCash();
		int quotient = 0;
		int rest = 0;
		
		quotient = quotientCalculation(cashValue, 100);
		rest = restCalculation(cashValue, 100);
		if (quotient > 0) {
			client.getBankNotes().setHundred(quotient);
		}
		if (rest > 0) {
			cashValue = rest;
			quotient = quotientCalculation(cashValue, 50);
			rest = restCalculation(cashValue, 50);
			if (quotient > 0) {
				client.getBankNotes().setFifty(quotient);
			}
			if (rest > 0) {
				cashValue = rest;
				quotient = quotientCalculation(cashValue, 20);
				rest = restCalculation(cashValue, 20);
				if (quotient > 0) {
					client.getBankNotes().setTwenty(quotient);
				}
				if (rest > 0) {
					cashValue = rest;
					quotient = quotientCalculation(cashValue, 10);
					if (quotient > 0) {
						client.getBankNotes().setTen(quotient);
					}
				}
			}
		}
	}
	
	private int quotientCalculation(int cashValue, int division) {
		return cashValue / division;
	}
	
	private int restCalculation(int cashValue, int division) {
		return cashValue % division;
	}
	
}
