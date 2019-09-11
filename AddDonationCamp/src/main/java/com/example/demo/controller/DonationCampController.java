package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DonationCamp;
import com.example.demo.model.Donor;
import com.example.demo.repo.RepositoryTemplate;

@RestController
public class DonationCampController {

	@Autowired
	RepositoryTemplate<DonationCamp> repo;
	
	@GetMapping("/getAll")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<DonationCamp> getAll(){
		System.out.println("0000000000000000000000000000000000method is called00000000000000000000000000");
		return this.repo.getAll();
	}
//	
//	@GetMapping("/get")
//	@CrossOrigin(origins = "http://localhost:3000")
//	public String get(){
//		return this.repo.get();
//	}
	
	@PostMapping("/addDonationCamp")
	public DonationCamp addDonationCamp(@RequestBody DonationCamp camp) {
		return this.repo.save(camp);
	}
	
//	@PostMapping("/addDonorToCamp/{id}")
//	@CrossOrigin(origins = "http://localhost:3000")
//	public DonationCamp addDonorToCamp(@PathVariable("id") int id,@RequestBody Donor donor) {
//		return this.repo.saveDonor(id,donor);
//	}
//	
	@GetMapping(value="/addDonorToCamp/{id}/{donorId}")
	public DonationCamp addDonorToCamp(@PathVariable("id") int id,@PathVariable("donorId") int donorId){
		System.out.println("=+++++++++++++++++++++ INSIDE CONTROLLER	 +++++++++++++++++++++++++");
		return this.repo.saveDonor(id,donorId);
	}
	
}
