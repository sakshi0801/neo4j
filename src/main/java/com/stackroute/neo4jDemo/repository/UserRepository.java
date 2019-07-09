package com.stackroute.neo4jDemo.repository;


import com.stackroute.neo4jDemo.model.Movie;
import com.stackroute.neo4jDemo.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    Collection<User> getAllUsers();

    User findByName(@Param("name") String name);

}
