package com.example.demo.modeles;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Agency")
public class AgencyEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String name;
private String address;
private String classe;


}