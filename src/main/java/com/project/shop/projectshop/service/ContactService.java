package com.project.shop.projectshop.service;

import com.project.shop.projectshop.model.Contact;
import com.project.shop.projectshop.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {
    @Autowired
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<Contact> contact() {
        return contactRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Contact show(Long id) {
        return contactRepository.findById(id).get();
    }

    public Contact save(Contact contact) {
        contactRepository.save(contact);

        return contact;
    }

    public Contact update(Long id, Contact contact) {
        Contact c = contactRepository.findById(id).get();
        if (contact.getName() != null)
            c.setName(contact.getName());
        if (contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if (contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if (contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        contactRepository.save(c);
        return contact;
    }
    public String delete(Long id) {
        Contact contact = contactRepository.findById(id).get() ;
        contactRepository.delete(contact);

        return "";
    }
}
