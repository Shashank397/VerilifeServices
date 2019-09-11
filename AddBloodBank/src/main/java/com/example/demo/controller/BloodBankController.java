package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BloodBank;
import com.example.demo.service.BloodBankService;

@RestController
public class BloodBankController {

	@Autowired
	BloodBankService service;

	@PostMapping(value = "/addBloodBank", produces = "application/json", consumes = "application/json")
	public BloodBank addBloodBank(@RequestBody BloodBank bloodBank) {
		return this.service.addBloodBankToDb(bloodBank);
	}
	
	@GetMapping(value = "/getAll")
	public List<BloodBank> getAll() {
		return this.service.findAllBloodBanks();
	}
	
//	@GetMapping(value = "/get/{id}")
//	public Optional<BLoodBank> getDonorById(@PathVariable("id") int id) {
//		return this.service.getDonorByIdFromDb(id);
//	}
//	
//	@DeleteMapping(value="/deleteDonor/{id}")
//	public String delete(@PathVariable("id") int id){
//		return this.service.deleteDonorFromDB(id);
//	}
//	
}

