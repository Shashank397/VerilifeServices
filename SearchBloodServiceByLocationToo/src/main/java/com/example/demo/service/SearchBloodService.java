package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.DonorData;
import com.example.demo.repository.SearchBloodRepository;



@Service
public class SearchBloodService {

	@Autowired
	private CrudRepository<DonorData, Integer> repo;
	
	
	public List<DonorData> searchByBloodGroup(String bloodGroup){
		SearchBloodRepository bloodRepo = (SearchBloodRepository) repo;
		return bloodRepo.findByBloodGroup(bloodGroup);
	}
	
	public List<DonorData> searchByBloodGroupAndLocation(String bloodGroup,String location){
		SearchBloodRepository bloodRepo = (SearchBloodRepository) repo;
		return bloodRepo.findByBloodGroupAndCity(bloodGroup, location);
	}
//
//	public Donor addDonorToDb(Donor donor) {
//		SearchBloodRepository bloodRepo = (SearchBloodRepository) repo;
//		return bloodRepo.save(donor);
//	}

}
