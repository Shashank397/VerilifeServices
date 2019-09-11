package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DonorData;

@Repository
public interface DonorRepository extends CrudRepository<DonorData, Integer> {

}
