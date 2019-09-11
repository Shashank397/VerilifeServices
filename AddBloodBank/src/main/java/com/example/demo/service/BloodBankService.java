package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.BloodBank;
import com.example.demo.repository.BloodBankRepository;

@Service
public class BloodBankService {

	@Autowired
	private CrudRepository<BloodBank, Integer> repo;
	
	public BloodBank addBloodBankToDb(BloodBank entity) {
		BloodBank obj = new BloodBank();
		obj = entity;
		obj.setEffective_date(LocalDate.now());
		return repo.save(obj);
	}
	
	
	public  List<BloodBank> findAllBloodBanks() {
		return (List<BloodBank>) repo.findAll();
	}

	public Optional<BloodBank> getDonorByIdFromDb(int id) {
		 return repo.findById(id);
	}
	
	public String deleteDonorFromDB(int id) {
		String result = "NO DONOR WITH THIS ID FOUND";
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			result = "DONOR SUCCESFULLY DELETED";
		}
		return result;
	}
	
	
}
