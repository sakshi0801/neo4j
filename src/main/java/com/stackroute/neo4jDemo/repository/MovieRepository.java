package com.stackroute.neo4jDemo.repository;

import com.stackroute.neo4jDemo.model.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie,Long> {

    @Query("MATCH (m:Movie) RETURN m")
    Collection<Movie> getAllMovies();

    Movie getByTitle(@Param("title") String title);
}
