package com.devs4j.users.services;

import com.devs4j.users.entity.Role;
import com.devs4j.users.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRole(Integer id){
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            roleRepository.deleteById(id);
        }else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro con esa id");
    }
}
