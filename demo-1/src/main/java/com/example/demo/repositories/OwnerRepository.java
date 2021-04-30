package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modeles.OwnerEntity;

public interface OwnerRepository extends  JpaRepository<OwnerEntity, Long>{

}
