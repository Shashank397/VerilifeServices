package com.example.demo.model;

import java.time.LocalDate;

public class SignupDonor {
	
	private int donor_id ;						//int(10);  SHOULD BE STRING  AND VAR
	   private String donor_name;   				//varchar(30) DEFAULT NULL,
	   private LocalDate dob ;							// date DEFAULT NULL,
	   private String bloodGroup;					// varchar(10) DEFAULT NULL,
	   private String phone_number ;				// mediumtext,
	   private String donor_availability ;			// tinyint(1) DEFAULT NULL,		SHOULD BE char and 
	   private String email;						// varchar(30) DEFAULT NULL,
	   private LocalDate effective_date;					// DATE OF REGISTRATION
	   private String line;				// varchar(50) DEFAULT NULL,
	   private String city ; 			//varchar(30) DEFAULT NULL,
	   private String state ; 			// varchar(30) DEFAULT NULL,
	   private String country;  		//varchar(30) DEFAULT NULL,
	   private int  pincode ;
	   private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getDonor_availability() {
		return donor_availability;
	}
	public void setDonor_availability(String donor_availability) {
		this.donor_availability = donor_availability;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(LocalDate effective_date) {
		this.effective_date = effective_date;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	} 
	   
	   

}
