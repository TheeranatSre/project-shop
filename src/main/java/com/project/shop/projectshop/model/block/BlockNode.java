package com.project.shop.projectshop.model.block;

import java.util.List;

import com.project.shop.projectshop.model.user.node.UserNode;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Node
@Data
public class BlockNode {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "BUY_SEll")
    private List<UserNode> userNodes;

    @Relationship(type = "CHAIN")
    private BlockNode chain;
}
