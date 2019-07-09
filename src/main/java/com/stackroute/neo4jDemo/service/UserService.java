package com.stackroute.neo4jDemo.service;

import com.stackroute.neo4jDemo.model.Movie;
import com.stackroute.neo4jDemo.model.Relationship;
import com.stackroute.neo4jDemo.model.User;
import com.stackroute.neo4jDemo.repository.MovieRepository;
import com.stackroute.neo4jDemo.repository.RelationshipRepository;
import com.stackroute.neo4jDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    public Collection<User> getAll(){
        return userRepository.getAllUsers();
    }

    public Collection<Movie> getMovies(){
        return movieRepository.getAllMovies();
    }

    public Movie saveMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public Movie getMovieByTitle(String title){
        return movieRepository.getByTitle(title);
    }

    public Relationship saveRelationship(String name,String title,Integer rating){
        User user=userRepository.findByName(name);
        Movie movie=movieRepository.getByTitle(title);
        Relationship relationship=new Relationship();
        relationship.setUser(user);
        relationship.setMovie(movie);
        relationship.setRating(rating);
        relationshipRepository.save(relationship);
        return relationship;
    }

    public Movie updateDirector(String title,String director){
        Movie movie=movieRepository.getByTitle(title);
        movie.setDirector(director);
        movieRepository.save(movie);
        return movie;
    }

    public User updateAge(User user){
        User user1=userRepository.findByName(user.getName());
        user1.setAge(user.getAge());
        userRepository.save(user1);
        return user1;
    }

    public Collection<User> deleteUser(String name){
        User user=userRepository.findByName(name);
        userRepository.delete(user);
        return userRepository.getAllUsers();
    }

    public void setUserMovies(User user1){
        Iterable<Relationship> relation=relationshipRepository.findAll();

        List<Movie> movies=new ArrayList<>();
        for (Relationship i:relation
             ) {

            User user=i.getUser();
            if(user.getName()==user1.getName()){
                movies.add(i.getMovie());
            }
        }
        user1.setMovies(movies);
        userRepository.save(user1);
    }
}
