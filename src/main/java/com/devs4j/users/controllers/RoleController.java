package com.devs4j.users.controllers;

import com.devs4j.users.entity.Role;
import com.devs4j.users.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles(){
        return new ResponseEntity<List<Role>>(roleService.getRoles(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable ("id") Integer id){
        roleService.deleteRole(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
