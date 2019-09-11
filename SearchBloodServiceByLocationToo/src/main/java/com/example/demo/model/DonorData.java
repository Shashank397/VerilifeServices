package com.example.demo.model;

import java.sql.Date;			// SQL DATE doesn't store time information, so used SQL Date instead of UTIL
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class DonorData {
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
	public String getBlood_group() {
		return bloodGroup;
	}
	public void setBlood_group(String blood_group) {
		this.bloodGroup = blood_group;
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
		@Id
	   @GeneratedValue
	   private int donor_id;						//int(10);  SHOULD BE STRING  AND VAR
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
	public DonorData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonorData(int donor_id, String donor_name, LocalDate dob, String blood_group, String phone_number,
			String donor_availability, String email, LocalDate effective_date, String line, String city, String state,
			String country, int pincode) {
		super();
		this.donor_id = donor_id;
		this.donor_name = donor_name;
		this.dob = dob;
		this.bloodGroup = blood_group;
		this.phone_number = phone_number;
		this.donor_availability = donor_availability;
		this.email = email;
		this.effective_date = effective_date;
		this.line = line;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	   
//	   @OneToOne(cascade = CascadeType.ALL)			
//	   @JoinColumn(name="donor_id",referencedColumnName = "user_id")
//	   private Address address;
	// Join column will create a new column with name specified in name attribute. Since name has donor_id which is already present
	// so donor_id itself is used as foreign key also. IF the name was something else(say abc), then a new column with abc name
	// would have been created and used as foreign key.
	   
}
