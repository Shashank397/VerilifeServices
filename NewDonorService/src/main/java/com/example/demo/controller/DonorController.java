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

import com.example.demo.model.DonorData;
import com.example.demo.service.DonorService;

@RestController
public class DonorController {

	@Autowired
	DonorService service;

	@PostMapping(value = "/addDonor", produces = "application/json", consumes = "application/json")
	public DonorData addDonor(@RequestBody DonorData donor) {
		return this.service.addDonorToDb(donor);
	}
	
//	@GetMapping(value = "/getAll")
//	public List<Donor> getAll() {
//		return this.service.findAllDonors();
//	}
	
	@GetMapping(value = "/get/{id}")
	public Optional<DonorData> getDonorById(@PathVariable("id") int id) {
		System.out.println("get method called ++++++++++++++++++");
		return this.service.getDonorByIdFromDb(id);
	}
	
	@DeleteMapping(value="/deleteDonor/{id}")
	public String delete(@PathVariable("id") int id){
		return this.service.deleteDonorFromDB(id);
	}
	
}

