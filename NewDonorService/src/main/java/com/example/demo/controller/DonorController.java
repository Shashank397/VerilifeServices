package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Credentials;
import com.example.demo.model.DonorData;
import com.example.demo.model.SignupDonor;
import com.example.demo.repository.CredentialsRepo;
import com.example.demo.service.DonorService;

@RestController
public class DonorController {

	@Autowired
	DonorService service;
	
	@Autowired
	private RestTemplate template;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	

	@PostMapping(value = "/addDonor", produces = "application/json", consumes = "application/json")
	public DonorData addDonor(@RequestBody DonorData donor) {
		return this.service.addDonorToDb(donor);
	}
	
	@PostMapping(value = "/signupDonor")
	@CrossOrigin(origins = "http://localhost:3000")
	public DonorData addDonor(@RequestBody SignupDonor Sdonor) {
		System.out.println("(((((((((((((((((((methid called ====="+Sdonor.getBloodGroup());
		DonorData donor = new DonorData();
		donor.setbloodGroup(Sdonor.getBloodGroup());
		donor.setCity(Sdonor.getCity());
		donor.setCountry(Sdonor.getCountry());
		donor.setDob(Sdonor.getDob());
		donor.setDonor_availability(Sdonor.getDonor_availability());
		donor.setDonor_name(Sdonor.getDonor_name());
		donor.setEffective_date(Sdonor.getEffective_date());
		donor.setEmail(Sdonor.getEmail());
		donor.setLine(Sdonor.getLine());
		donor.setPhone_number(Sdonor.getPhone_number());
		donor.setPincode(Sdonor.getPincode());
		donor.setState(Sdonor.getState());
		Credentials cred = new Credentials();
		cred.setUsername(Sdonor.getEmail());
		cred.setPassword(encoder.encode(Sdonor.getPassword()));
		service.saveCred(cred);
		return template.postForObject("http://new-donor/addDonor",donor, DonorData.class);
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

