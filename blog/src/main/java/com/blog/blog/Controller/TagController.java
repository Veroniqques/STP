package com.blog.blog.Controller;


import com.blog.blog.Service.TagService;
import com.blog.blog.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @PostMapping(value = "/api/tags")
    public ResponseEntity<?> create(@RequestBody Tag tag){
        tagService.create(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/tags")
    public  ResponseEntity<List<Tag>> findAll(){
        final List<Tag> blogList = tagService.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/tags/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Tag> blog = tagService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/tags/{id}")
    public ResponseEntity<?> updateTag(@RequestBody Tag tag, @PathVariable(name = "id")Long id){
        if (tagService.findById(id).isPresent()) {
            tagService.updateTag(tag, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/tags/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable(name = "id") Long id){
        if (tagService.findById(id).isPresent()){
            tagService.deleteTag(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/tags")
    public void deleteAll(){
        tagService.deleteAll();
    }

}
