package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modeles.AdminEntity;

public interface AdminRepository extends  JpaRepository<AdminEntity, Long> {

}
