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

import org.springframework.beans.factory.annotation.Value;


@Entity
@Table(name = "blood_bank_data")
public class BloodBank {
	   @Id
	   @GeneratedValue
	   private int blood_bank_id ;						//int(10);  SHOULD BE STRING  AND VAR
	   private String blood_bank_name;   				//varchar(30) DEFAULT NULL,
	   private String phone_number ;				// mediumtext, 
	   private String email;						// varchar(30) DEFAULT NULL,
	   private String address;				// varchar(50) DEFAULT NULL,
	   private String city ; 			//varchar(30) DEFAULT NULL,
	   private String state ; 			// varchar(30) DEFAULT NULL,
	   private String country;  		//varchar(30) DEFAULT NULL,
	   private int  pincode ;
	   private int opos;
	   private int oneg;
	   private int apos;
	   private int aneg;
	   private int bpos;
	   private int bneg;
	   private int abpos;
	   private int abneg;
	   
	   
	   @Value("${LocalDate.now()}")
	   private LocalDate effective_date;					// DATE OF REGISTRATION


	public int getBlood_bank_id() {
		return blood_bank_id;
	}


	public void setBlood_bank_id(int blood_bank_id) {
		this.blood_bank_id = blood_bank_id;
	}


	public String getBlood_bank_name() {
		return blood_bank_name;
	}


	public void setBlood_bank_name(String blood_bank_name) {
		this.blood_bank_name = blood_bank_name;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public int getOpos() {
		return opos;
	}


	public void setOpos(int opos) {
		this.opos = opos;
	}


	public int getOneg() {
		return oneg;
	}


	public void setOneg(int oneg) {
		this.oneg = oneg;
	}


	public int getApos() {
		return apos;
	}


	public void setApos(int apos) {
		this.apos = apos;
	}


	public int getAneg() {
		return aneg;
	}


	public void setAneg(int aneg) {
		this.aneg = aneg;
	}


	public int getBpos() {
		return bpos;
	}


	public void setBpos(int bpos) {
		this.bpos = bpos;
	}


	public int getBneg() {
		return bneg;
	}


	public void setBneg(int bneg) {
		this.bneg = bneg;
	}


	public int getAbpos() {
		return abpos;
	}


	public void setAbpos(int abpos) {
		this.abpos = abpos;
	}


	public int getAbneg() {
		return abneg;
	}


	public void setAbneg(int abneg) {
		this.abneg = abneg;
	}


	public LocalDate getEffective_date() {
		return effective_date;
	}


	public void setEffective_date(LocalDate effective_date) {
		this.effective_date = effective_date;
	}
	   
	   
	
}
