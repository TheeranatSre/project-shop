package com.project.shop.projectshop.model.buyproduct.requset.node;

import com.project.shop.projectshop.model.user.node.UserNode;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Node
@Data
public class BuyNode {
  @Id
  private Long id;

  @Relationship(type="buy")
  private UserNode userBuy;

  @Relationship(type="sell")
  private UserNode userSell;
  
}
