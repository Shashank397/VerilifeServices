package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Credentials;

@Repository
public interface CredentialsRepo extends CrudRepository<Credentials, String> {
	
	Credentials findByUsername(String username);

}
