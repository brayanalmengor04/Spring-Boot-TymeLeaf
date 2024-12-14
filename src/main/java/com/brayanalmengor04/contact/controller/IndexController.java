package com.brayanalmengor04.contact.controller;

import com.brayanalmengor04.contact.entities.Contact;
import com.brayanalmengor04.contact.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {

    private static final Logger logger =
            LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String index(ModelMap model) {
        List<Contact> contacts = contactService.getAllContacts();
        contacts.forEach(contact -> logger.info(contact.toString()));
        model.put("contacts", contacts);
        return "index";
    }

    @GetMapping("/add")
    public String showAdd() {
        return "add";
    }
    @PostMapping("/add")
    public String addContact(@ModelAttribute("contactForm") Contact contact) {
        logger.info("COntacto a agregar "+contact);
        contactService.addContact(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{idContact}")
    public String showEdit(@PathVariable(value = "idContact") Integer idContact, ModelMap model) {
        Contact contact = contactService.getContactById(idContact);
        logger.info("Conntacto a editar "+contact);
        model.put("contact", contact);
        return "edit";
    }

    @PostMapping("/edit")
    public String editContact(@ModelAttribute("contact") Contact contact) {
            logger.info("Contacto a editar "+contact);
            contactService.addContact(contact);
            return "redirect:/";
    }

    @GetMapping("/delete/{idContact}")
    public String deleteContact(@PathVariable(value = "idContact") Integer idContact) {
        Contact contact = new Contact();
        contact.setIdContact(idContact);
        contactService.deleteContact(contact);
        logger.info("Contacto a eliminar "+idContact);
        return "redirect:/";
    }

}
