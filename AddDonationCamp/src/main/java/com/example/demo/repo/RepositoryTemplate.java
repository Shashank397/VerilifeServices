package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.DonationCamp;
import com.example.demo.model.Donor;


public interface RepositoryTemplate<T> {

		public T save(T t);
		public List<T> getAll();
		public long remove(T t);
		public String get();
		public DonationCamp saveDonor(int id,int donorId);
}
