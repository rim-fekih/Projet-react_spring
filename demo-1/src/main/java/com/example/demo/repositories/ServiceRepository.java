package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modeles.ServiceEntity;

public interface ServiceRepository extends  JpaRepository<ServiceEntity, Long>{
	
}
