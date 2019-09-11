package com.example.demo.config;

import java.sql.Date;
import java.util.Arrays;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.model.DonationCamp;
import com.example.demo.model.Donor;
import com.mongodb.MongoClient;

@Configuration
public class AppConfig {
	
//	@Bean
//	public DonationCamp donationCamp(){
//		DonationCamp d = new DonationCamp();
//		d.setId(1);
//		d.setName("ABC Camp");
//		d.setToDate(new Date(0));
//		d.setFromDate(new Date(0));
//		d.setTimings("3am to 9pm");
//		d.setDonorList(Arrays.asList(new Donor(),new Donor()));
//		return d;
//	}
}
