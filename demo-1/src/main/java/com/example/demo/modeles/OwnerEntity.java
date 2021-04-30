package com.example.demo.modeles;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Owner")
public class OwnerEntity extends UserEntity{
	private String niveau;
//	@JsonIgnore
	//@OneToMany(mappedBy = "Owner")
	//private List<ServiceEntity> Services;
	

}
