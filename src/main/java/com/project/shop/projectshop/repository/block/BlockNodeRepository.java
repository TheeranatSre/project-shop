package com.project.shop.projectshop.repository.block;

import com.project.shop.projectshop.model.block.BlockNode;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BlockNodeRepository extends Neo4jRepository<BlockNode, Long> {
  
}
