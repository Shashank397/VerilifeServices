package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Address;
import com.example.demo.model.DonorData;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class NewDonorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewDonorServiceApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate template() 
	{
		return new RestTemplate();
	}
}
