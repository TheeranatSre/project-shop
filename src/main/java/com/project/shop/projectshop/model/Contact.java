package com.project.shop.projectshop.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@NotEmpty
@Data
public class Contact {
    @Id
    private Long id;
    private String name;
    @Relationship(type="ADD-DRESS")
    private Address address;
    private String city;
    private String phone;
    private String email;
    @Relationship(type="NEW-NODE")
    private Contact contact;
}
