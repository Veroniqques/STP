package com.blog.blog.Controller;


import com.blog.blog.Service.ComService;
import com.blog.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComController {
    private final ComService comService;

    @Autowired
    public ComController(ComService comService){
        this.comService = comService;
    }

    @PostMapping(value = "/api/comments")
    public ResponseEntity<?> create(@RequestBody Comment comment){
        comService.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/comments")
    public  ResponseEntity<List<Comment>> findAll(){
        final List<Comment> blogList = comService.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/comments/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Comment> blog = comService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/comments/{id}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment, @PathVariable(name = "id")Long id){
        if (comService.findById(id).isPresent()) {
            comService.updateComment(comment, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "id") Long id){
        if (comService.findById(id).isPresent()){
            comService.deleteComment(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/comments")
    public void deleteAll(){
        comService.deleteAll();
    }

}
