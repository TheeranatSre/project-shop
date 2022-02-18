package com.project.shop.projectshop.controller;

import com.project.shop.projectshop.model.Contact;
import com.project.shop.projectshop.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET,value = "/contacts")
    public Iterable<Contact> contact(){
        return contactService.contact();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/contacts")
    public Contact save(@RequestBody Contact contact){
        return contactService.save(contact);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/contacts/{id}")
    public Contact show(@PathVariable Long id){
        return contactService.show(id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/contacts/{id}")
    public Contact update(@PathVariable Long id,@RequestBody Contact contact){
       return contactService.update(id,contact);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/contacts/{id}")
    public String delete(@PathVariable Long id){
        contactService.delete(id);
        return "";
    }
}
