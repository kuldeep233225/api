package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "api")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdNumber;
	private String name;
	private String fatherName;
	private String mobile;
	private String gmail; 

	
}
