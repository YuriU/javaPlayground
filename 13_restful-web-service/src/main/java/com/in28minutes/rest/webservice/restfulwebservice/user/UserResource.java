package com.in28minutes.rest.webservice.restfulwebservice.user;

import com.in28minutes.rest.webservice.restfulwebservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUsers(@PathVariable int id) {
        User user =  service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("User is not found " + id);
        }

        var linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        EntityModel<User> resource = EntityModel.of(user, List.of(linkBuilder.withRel("all-users")));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<URI> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
