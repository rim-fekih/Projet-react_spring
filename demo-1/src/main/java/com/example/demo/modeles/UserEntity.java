package com.example.demo.modeles;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@MappedSuperclass
public abstract  class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	//	private LocalDate dateOfBirth;
	
	private String prenom;
	private String email;
	private String Password ;
}
