package com.in28minutes.rest.webservice.restfulwebservice.user;

import com.in28minutes.rest.webservice.restfulwebservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUsers(@PathVariable int id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found " + id));

        var linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        EntityModel<User> resource = EntityModel.of(user, List.of(linkBuilder.withRel("all-users")));
        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<URI> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUserPosts(@PathVariable int id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found " + id));

        return user.getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<URI> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found " + id));

        post.setUser(user);
        var savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
