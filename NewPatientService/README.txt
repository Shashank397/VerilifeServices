# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/maven-plugin/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#production-ready)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-sql)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)



### NEW PATIENT SERVICE
PRIMARY FUNCTION : To add a new patient to the patient database.

### MODELS
1. Patient class - Contains the basic information about patient like name,dob etc. 
2. Address class -  This class contains the address for both patient as well as the patient. It 'user_id' column as the foreign key which is mapped to patient_id/patient id. In this way we will not have to save address separately for patient and patient.


### DATABASE INFO
Type - MySQL
Name - verilife_db
Table Name - patient_data


### PORT NUMBER AND APPLICATION PROPERTIES
PORT NUMBER - 1011
DATABASE PORT - 3306
DATABASE USER - root
DATABASE PASS - admin
Change database port,user and pass according to your local machine.


### PRIMARY ENDPOINT 
ENDPOINT - /addPatient  
We can send data using postman or in swagger

### ADDITIONAL ENDPOINTS  :
Just to check if service is working or not 
1. /getALL  --> Fetch all the patient from the database
2. /get/id 	--> To fetch a particular patient from database based on the id provided by the user.
3. /deletePatient  --> Deletes the patient from the database based on the id provided. The address of the patient will automatically be removed from address table as both are joined.


### CONTROLLER AND MAPPED SERVICES  ie.    Controller(Service)
1. addPatient(addPatientToDb) - adds the database to the database. If added, status code = 200
2. getAll(findAllPatients) - Displays the list of Patients available in the patient database
3. getPatientById(getPatientByIdFromDb) - Displays the patient based on the provided id . If id not present - returns null
4. delete(deletePatientFromDB) - Displays "PATIENT SUCCESFULLY DELETED" if patient with given id present else displays "NO PATIENT WITH THIS ID FOUND" 


### TO TEST SERVICES
1. Using POSTMAN :
a) POST -> http://localhost:1011/addPatient
Body->raw->json
{
	"patient_id":12345,				
	"blood_group" : "bpos",
	"dob": "1997-10-02",
	"patient_availability":"Y",
	"patient_name":"Shubham Kandwal",
	"effective_date":"2019-09-01",
	"email":"shubham@yahoo.com",
	"phone_number":"9876543321",
	"address":{
		"city":"Chandigarh",
		"country":"India",
		"line":"#756,Sector-10C",
		"pincode" : "160009",
		"state":"Chandigarh"
	}
}

b) GET -> http://localhost:1011/getAll
c) GET -> http://localhost:1011/get/1
d) DELETE -> http://localhost:1011/deletePatient/1

2. SWAGGER : Go to http://localhost:1011/swagger-ui.html 
- Go to patient-controller
- Click on the service to test(eg. POST,GET etc). 
- Click Try it out option
- If POST request - Fill the JSON data  or If GET/DELETE/PUT request - provide the id (if required) 
- Click execute.
- Check for status code . If status code = 200 --> Successfull else some error.


### POINT TO DISCUSS AND THINK
1. Added a column named 'EFFECTIVE_DATE'. It records the date, the entry has been made in data base.
2. Similarly we can include a column say 'LAST_REFRESHED' of DATE type - to record when was the last time the patient donated the blood.
3. Related to datatypes or values:
	a) patient_id : Should be long int or String. (currently int) . Preferred String - Something like DNR001
	b) blood groups : what are the possible values to keep?  opos,bneg or simply O+,B- etc. . Need to list of all the possible values for blood group even rarest.
	c) phone_number : Type should be int or String. String is preferred 
	e) pincode : In address table. int or string. (String preferred)

### POINTS YET TO IMPLEMENT
1. Adding service to EUREKA SERVER
2. Fault tolerance and Load Balancing

