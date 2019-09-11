package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DonorData;

@Repository
public interface SearchBloodRepository extends CrudRepository<DonorData, Integer> {
	
	
	public List<DonorData> findByBloodGroup(String bloodGroup);
	public List<DonorData> findByBloodGroupAndCity(String bloodGroup,String city);

}
