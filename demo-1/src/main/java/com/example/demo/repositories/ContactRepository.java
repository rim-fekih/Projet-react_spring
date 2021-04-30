package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modeles.Contact;

public interface ContactRepository extends  JpaRepository<Contact, Long> {

}
