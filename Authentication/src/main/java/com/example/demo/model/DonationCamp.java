package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalTime;

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
	private List<Integer> donorList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public int getFromTime() {
		return fromTime;
	}
	public void setFromTime(int fromTime) {
		this.fromTime = fromTime;
	}
	public int getToTime() {
		return toTime;
	}
	public void setToTime(int toTime) {
		this.toTime = toTime;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Integer> getDonorList() {
		return donorList;
	}
	public void setDonorList(List<Integer> donorList) {
		this.donorList = donorList;
	}
	
	
	
	}
