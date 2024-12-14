package com.brayanalmengor04.contact.service;

import com.brayanalmengor04.contact.entities.Contact;
import com.brayanalmengor04.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService{

    @Autowired
    private  ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    @Override
    public Contact getContactById(Integer idContact) {
        Contact contact = contactRepository.findById(idContact).orElse(null);
        return contact;
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
}
