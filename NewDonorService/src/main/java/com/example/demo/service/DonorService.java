package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Credentials;
import com.example.demo.model.DonorData;
import com.example.demo.repository.CredentialsRepo;
import com.example.demo.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired
	private CrudRepository<DonorData, Integer> repo;
	
	@Autowired
	private CredentialsRepo crepo;
	
	public DonorData addDonorToDb(DonorData entity) {
		entity.setEffective_date(LocalDate.now());
		return repo.save(entity);
	}
	
	
	public  List<DonorData> findAllDonors() {
		return (List<DonorData>) repo.findAll();
	}

	public Optional<DonorData> getDonorByIdFromDb(int id) {
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
	
	public void saveCred(Credentials entity)
	{
		crepo.save(entity);
	}
	
}
