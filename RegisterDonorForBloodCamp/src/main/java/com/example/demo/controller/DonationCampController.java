package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DonationCamp;
import com.example.demo.repo.RepositoryTemplate;

@RestController
public class DonationCampController {

	@Autowired
	RepositoryTemplate<DonationCamp> repo;
	
	@GetMapping("/getAll")
	public List<DonationCamp> getAll(){
		return this.repo.getAll();
	}
	
	@GetMapping("/get")
	public String get(){
		return this.repo.get();
	}
	
	@PostMapping("/addDonationCamp")
	public DonationCamp addDonationCamp(@RequestBody DonationCamp camp) {
		return this.repo.save(camp);
	}
}
