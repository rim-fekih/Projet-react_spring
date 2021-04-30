package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.modeles.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}