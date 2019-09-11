package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService service;
	
	
	@PostMapping(value = "/addPatient", produces = "application/json", consumes = "application/json")
	public Patient addPatient(@RequestBody Patient Patient) {
		return this.service.addPatientToDb(Patient);
	}
	
//	@GetMapping(value = "/getAll")
//	public List<Patient> getAll() {
//		return this.service.findAllPatients();
//	}
	
	@GetMapping(value = "/get/{id}")
	public Optional<Patient> getPatientById(@PathVariable("id") int id) {
		return this.service.getPatientByIdFromDb(id);
	}
	
	@DeleteMapping(value="/deletePatient/{id}")
	public String delete(@PathVariable("id") int id){
		return this.service.deletePatientFromDB(id);
	}
}
