package com.blog.blog.Controller;

import com.blog.blog.Service.PostService;
import com.blog.blog.entity.Post;
import com.fasterxml.jackson.databind.node.POJONode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping(value = "/api/posts")
    public ResponseEntity<?> create(@RequestBody Post post){
        postService.create(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/posts")
    public  ResponseEntity<List<Post>> findAll(){
        final List<Post> blogList = postService.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/posts/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Post> blog = postService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/posts/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable(name = "id")Long id){
        if (postService.findById(id).isPresent()) {
            postService.updatePost(post, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id){
        if (postService.findById(id).isPresent()){
            postService.deletePost(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/posts")
    public void deleteAll(){
        postService.deleteAll();
    }

}
