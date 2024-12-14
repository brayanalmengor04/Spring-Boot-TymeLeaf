package com.brayanalmengor04.contact.repository;

import com.brayanalmengor04.contact.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
