package com.exercise.atm.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exercise.atm.api.documents.Client;


public interface ClientRepository extends MongoRepository<Client, String> {

}
