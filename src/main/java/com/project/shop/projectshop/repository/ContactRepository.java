package com.project.shop.projectshop.repository;

import java.util.Collection;

import com.project.shop.projectshop.model.Contact;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ContactRepository extends Neo4jRepository<Contact, Long> {
    Collection<Contact> findByName(String name);

    @Override
    void delete(Contact deleted);
}
