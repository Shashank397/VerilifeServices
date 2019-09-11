package com.example.demo.repo;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Query.query;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DonationCamp;
import com.example.demo.model.Donor;
import com.example.demo.service.CustomSequences;
import com.example.demo.service.NextSequenceService;

@Repository
public class DonationCampRepository implements RepositoryTemplate<DonationCamp> {

	@Autowired
	private MongoTemplate template;				// We should provide either constructor or setter dependency. Even if we don't the spring itself does.
	
	@Autowired
	private NextSequenceService service;
	
    @Autowired private MongoOperations mongo;

	@Override
	public DonationCamp save(DonationCamp t) {
		DonationCamp obj = new DonationCamp();
		obj = t;
		obj.setId(service.getNextSequence("customSequences"));
		List<Integer> donorList = new ArrayList<>();
		obj.setDonorList(donorList);
		System.out.println("==================================");
		System.out.println(obj.getCity());
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

	@Override
	public DonationCamp saveDonor(int id,int donorId) {
		System.out.println("=+++++++++++++++++++++ METHOD CALLED +++++++++++++++++++++++++");
		DonationCamp camp = mongo.findAndModify(
				query(where("_id").is(id)),
	            new Update().push("donorList",donorId),
	            options().returnNew(true).upsert(true),
	            DonationCamp.class);
			
		return camp;
	}
	
}
