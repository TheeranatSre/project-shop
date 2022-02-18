package com.project.shop.projectshop.model.user.node;

import org.springframework.data.neo4j.core.schema.Id;

import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;

@Node
@Data
public class UserNode {
  @Id
  Long id;

  private String name;

  private String email;

  private String role;

  private Long bitcoin;
}
