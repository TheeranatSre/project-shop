package com.project.shop.projectshop.repository.block;

import com.project.shop.projectshop.model.block.relationship.BlockRelationship;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BlockRelationshipRepository extends Neo4jRepository<BlockRelationship, Long> {
  
}
