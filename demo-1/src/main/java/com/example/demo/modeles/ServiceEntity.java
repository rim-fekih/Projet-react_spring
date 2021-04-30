package com.example.demo.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
@Table(name = "Service")
public class ServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
    private String destination;
	@Column
    private  int nombredeplace;
   //private LocalDate date;
	@JsonIgnore
	//@ManyToOne
	//private OwnerEntity Owner;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNombredeplace() {
		return nombredeplace;
	}
	public void setNombredeplace(int nombredeplace) {
		this.nombredeplace = nombredeplace;
	}

	public ServiceEntity(Long id, String name, String destination, int nombredeplace) {
		super();
		this.id = id;
		this.name = name;
		this.destination = destination;
		this.nombredeplace = nombredeplace;
		
	}
	public ServiceEntity() {
		super();
	}

		
	


	
}
