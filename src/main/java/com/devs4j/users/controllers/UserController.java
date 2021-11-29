package com.devs4j.users.controllers;



import com.devs4j.users.entity.User;
import com.devs4j.users.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                               @RequestParam(value = "size", required = false, defaultValue = "100") Integer size){
        return new ResponseEntity<Page<User>>(userService.getUsers(page, size), HttpStatus.OK);
    }
    @GetMapping(value = "/{username}")
    public ResponseEntity<List<User>> getuserByUsername(@PathVariable("username") String username){
        return new ResponseEntity<List<User>>(userService.findByUsername(username),HttpStatus.OK);
    }
    @GetMapping(value = "/id/{id}")
    @ApiOperation(value = "Returns a user by a given id", response = User.class)
    public ResponseEntity<User> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
    }

}
