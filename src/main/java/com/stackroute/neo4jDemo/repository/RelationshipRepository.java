package com.stackroute.neo4jDemo.repository;

import com.stackroute.neo4jDemo.model.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RelationshipRepository extends Neo4jRepository<Relationship,Long> {
}
