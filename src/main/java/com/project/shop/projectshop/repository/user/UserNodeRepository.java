package com.project.shop.projectshop.repository.user;

import com.project.shop.projectshop.model.user.node.UserNode;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserNodeRepository extends Neo4jRepository<UserNode, Long> {
  
}
