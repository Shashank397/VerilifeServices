package com.example.demo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor{

	   private int donor_id ;						//int(10);  SHOULD BE STRING  AND VARCHAR
	   private String donor_name;   				//varchar(30) DEFAULT NULL,
	   private LocalDate dob ;							// date DEFAULT NULL,
	   private String blood_group;					// varchar(10) DEFAULT NULL,
	   private String phone_number ;				// mediumtext,
	   private char donor_availability ;			// tinyint(1) DEFAULT NULL,		SHOULD BE boolean and 
	   private String email;						// varchar(30) DEFAULT NULL,
	   private String line;				// varchar(50) DEFAULT NULL,
	   private String city ; 			//varchar(30) DEFAULT NULL,
	   private String state ; 			// varchar(30) DEFAULT NULL,
	   private String country;  		//varchar(30) DEFAULT NULL,
	   private int  pincode ;
	
}
