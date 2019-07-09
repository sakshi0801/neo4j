package com.stackroute.neo4jDemo.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private Long id;
    private String name;
    private Integer age;

    @Relationship(type = "RATED",direction = Relationship.INCOMING)
    private List<Movie> movies;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
