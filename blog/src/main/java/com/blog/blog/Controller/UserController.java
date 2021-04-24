package com.blog.blog.Controller;


import com.blog.blog.Service.UserService;
import com.blog.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/api/users")
    public ResponseEntity<?> create(@RequestBody User user){
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/users")
    public  ResponseEntity<List<User>> findAll(){
        final List<User> blogList = userService.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/users/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<User> blog = userService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable(name = "id")Long id){
        if (userService.findById(id).isPresent()) {
            userService.updateUser(user, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id){
        if (userService.findById(id).isPresent()){
            userService.deleteUser(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/users")
    public void deleteAll(){
        userService.deleteAll();
    }

}
