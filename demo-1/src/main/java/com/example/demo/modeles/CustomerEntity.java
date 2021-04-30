package com.example.demo.modeles;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class CustomerEntity extends UserEntity{
	private  String address;
	@JsonIgnore
	private  String sex;
	@OneToMany(mappedBy = "customer")
	private List<BookingEntity> bookings;
}
