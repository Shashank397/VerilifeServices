package com.example.demo.repo;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DonationCamp;

@Repository
public class DonationCampRepository implements RepositoryTemplate<DonationCamp> {

	@Autowired
	private MongoTemplate template;				// We should provide either constructor or setter dependency. Even if we don't the spring itself does.

	@Override
	public DonationCamp save(DonationCamp t) {
		return template.save(t);
	}

	@Override
	public List<DonationCamp> getAll() {
		return template.findAll(DonationCamp.class);
	}
	
	@Override
	public String get() {
		return "HI!! iTs working.";
	}

	@Override
	public long remove(DonationCamp t) {
		return template.remove(t).getDeletedCount();
	}
	
}
