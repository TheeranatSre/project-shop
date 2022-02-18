package com.project.shop.projectshop.repository.userbuy;

import com.project.shop.projectshop.model.buyproduct.requset.node.BuyNode;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BuyNodeRepository extends Neo4jRepository<BuyNode, Long> {
}
