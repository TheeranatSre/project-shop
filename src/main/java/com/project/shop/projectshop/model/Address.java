package com.project.shop.projectshop.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Data
@Node
public class Address {
  @Id
  private Long id;

  private String address;

  @Relationship(type="ADD-DRESS")
  private Contact contact;
}
