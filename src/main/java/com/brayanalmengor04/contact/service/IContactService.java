package com.brayanalmengor04.contact.service;

import com.brayanalmengor04.contact.entities.Contact;

import java.util.List;

public interface IContactService {

    public List<Contact> getAllContacts();
    public Contact getContactById(Integer idContact);
    public void addContact(Contact contact);
    public void deleteContact(Contact contact);
}
