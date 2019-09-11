package com.example.demo.service;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customSequences")
public class CustomSequences {
    @Id
    private String id;
    private int seq;

// getters and setters
}