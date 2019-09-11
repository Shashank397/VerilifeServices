package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.model.BloodBank;
import com.example.demo.model.Credentials;
import com.example.demo.model.DonationCamp;
import com.example.demo.model.DonationComponentList;
import com.example.demo.model.DonorData;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.Patient;
import com.example.demo.model.SignupDonor;
import com.example.demo.service.CredentialsService;

@RestController
public class ServiceController {

	@Autowired
	private CredentialsService service;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	private Credentials cred = new Credentials();

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private CredentialsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	
	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	final String token = jwtTokenUtil.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	private void authenticate(String username, String password) throws Exception {
	
		try {
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
	throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e) {
	throw new Exception("INVALID_CREDENTIALS", e);
	}
	}
	
	
	
	
	

	// Donor Services
	@PostMapping(value = "/addDonor")
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
	
//	@GetMapping(value = "/get/{id}")
//	public Patient getDonorById(@PathVariable("id") int id) {
//		return template.getForObject("http://new-donor/get/"+id, Patient.class);
//	}
	
	//Patient services
	@PostMapping(value = "/addPatient", produces = "application/json", consumes = "application/json")
	public Patient addPatient(@RequestBody Patient patient) {
		return template.postForObject("http://new-patient/addPatient", patient, Patient.class);
	}
	
//	@GetMapping(value = "/get/{id}")
//	public Patient getPatientById(@PathVariable("id") int id) {
//		return template.getForObject("http://new-patient/get/"+id, Patient.class);
//	}
	
	//Donation camp service 
	@GetMapping("/getAll")
	public List<DonationCamp> getAll(){
		return  template.getForObject("http://register-donation-camp/getAll", List.class); 
	}
//	@PostMapping("/addDonationCamp")
//	public DonationCamp addDonationCamp(@RequestBody DonationCamp camp) {
//		return template.postForObject("http://register-blood-bank/addDonationCamp", camp, DonationCamp.class);
//	}
	
	//search blood bank service
	@GetMapping("/search/{blood_group}/{location}")
	public List<DonorData> searchDonorByBloodGroupAndLocation(@PathVariable("blood_group") String bloodGroup,@PathVariable("location") String location){
		return template.getForObject("http://search-blood-service/search/"+bloodGroup+"/"+location, List.class);
	}
	
	//AddBoolBank services
	@PostMapping(value = "/addBloodBank", produces = "application/json", consumes = "application/json")
	public BloodBank addBloodBank(@RequestBody BloodBank bloodBank) {
		return template.postForObject("http://new-blood-bank/addBloodBank", bloodBank, BloodBank.class);
	}
	
	
	//New Donation camp and donor
	@GetMapping(value="/addDonorToCamp/{id}/{donorId}")
	public DonationCamp addDonorToCamp(@PathVariable("id") int id,@PathVariable("donorId") int donorId){
		System.out.println("=+++++++++++++++++++++ INSIDE CONTROLLER	 +++++++++++++++++++++++++");
		return template.getForObject("http://register-donation-camp/addDonorToCamp/{id}/{donorId}"+id+"/"+donorId, DonationCamp.class);
	}
	
	@PostMapping("/addDonationCamp")
	public DonationCamp addDonationCamp(@RequestBody DonationCamp camp) {
		return template.postForObject("http://register-donation-camp/addDonationCamp", camp, DonationCamp.class);
	}
	
	
	
}
