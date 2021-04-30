package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.ServiceEntity;



public interface CustomerRepository extends  JpaRepository<CustomerEntity, Long>{
	Optional<CustomerEntity> findByEmail(String email);

}
