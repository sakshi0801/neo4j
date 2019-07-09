package com.stackroute.neo4jDemo.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "RATED")
public class Relationship {

    @GraphId
    private Long id;

    @EndNode
    private User user;

    @StartNode
    private Movie movie;

    private Integer rating;

    public Relationship() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
