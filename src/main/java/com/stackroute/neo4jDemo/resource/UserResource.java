package com.stackroute.neo4jDemo.resource;

import com.stackroute.neo4jDemo.model.Movie;
import com.stackroute.neo4jDemo.model.Relationship;
import com.stackroute.neo4jDemo.model.User;
import com.stackroute.neo4jDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Collection<User> getAll(){
        Collection<User> users = userService.getAll();

        for (User u:users
             ) {
            userService.setUserMovies(u);
        }
        return userService.getAll();
    }

    @GetMapping("/movies")
    public Collection<Movie> getMovies(){
        return userService.getMovies();
    }

    @PostMapping("/movie")
    public Movie saveNewMovie(@RequestBody Movie movie){
        return userService.saveMovie(movie);
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/user/{name}")
    public User getByName(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/movie/{title}")
    public Movie getMovieByTitle(@PathVariable("title") String title){
        return userService.getMovieByTitle(title);
    }

    @PostMapping("/relation/{name}/{title}/{rating}")
    public Relationship saveRelation(@PathVariable("name") String name, @PathVariable("title") String title, @PathVariable("rating") Integer rating ){
        return userService.saveRelationship(name,title,rating);
    }

    @PutMapping("/movie")
    public Movie updateDirector(@RequestBody Movie movie){
        return userService.updateDirector(movie.getTitle(),movie.getDirector());
    }

    @PutMapping("/user")
    public User updateAge(@RequestBody User user){
        return userService.updateAge(user);
    }

    @DeleteMapping("/user")
    public Collection<User> deleteUser(@RequestBody User user){
        return userService.deleteUser(user.getName());
    }
}
