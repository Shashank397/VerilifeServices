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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@AllArgsConstructor
@NoArgsConstructor
@Data
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
	   
	   
	   
	   private LocalDate effective_date;					// DATE OF REGISTRATION
	
}
