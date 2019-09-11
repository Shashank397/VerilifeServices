package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection="verilife_db")						// Like @Entity...and cars is a 
@Data
public class DonationCamp {

	@Id
	private int id;
	private String name;
	
	@DateTimeFormat(iso= ISO.DATE)
	private LocalDate fromDate;
	
	@DateTimeFormat(iso= ISO.DATE)
	private LocalDate toDate;
	
//	@DateTimeFormat(iso = ISO.TIME)
//	private LocalTime fromTime;
//	
//	@DateTimeFormat(iso = ISO.TIME)
//	private LocalTime toTime;
	
	private int fromTime;
	private int toTime;	
	//private String timings;
	private String venue;
	private String city;
	private List<Donor> donorList;
	}
