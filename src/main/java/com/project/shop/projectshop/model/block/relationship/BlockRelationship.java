package com.project.shop.projectshop.model.block.relationship;
import com.project.shop.projectshop.model.block.BlockNode;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Node
@Data
public class BlockRelationship {
  @Id
  @GeneratedValue
  private Long id;

  @Relationship(type = "INPUT_CODE")
  private BlockNode blockInputCode;

  @Relationship(type = "OUTPUT_CODE")
  private BlockNode blockOutput;
}
