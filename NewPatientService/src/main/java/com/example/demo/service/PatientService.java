package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.model.Patient;

@Service
public class PatientService {

	@Autowired
	private CrudRepository<Patient, Integer> repo;
	
	public Patient addPatientToDb(Patient entity) {
		entity.setEffective_date(LocalDate.now());
		return repo.save(entity);
	}
	
	
	public  List<Patient> findAllPatients() {
		return (List<Patient>) repo.findAll();
	}

	public Optional<Patient> getPatientByIdFromDb(int id) {
		 return repo.findById(id);
	}
	
	public String deletePatientFromDB(int id) {
		String result = "PATIENT SUCCESFULLY DELETED";
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			
		}else
		{
			result = "NO PATIENT WITH THIS ID FOUND";
		}
		
		return result;
	}
}
