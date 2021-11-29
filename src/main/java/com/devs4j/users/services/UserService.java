package com.devs4j.users.services;

import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsers(Integer page, Integer size){
        return userRepository.findAll(PageRequest.of(page, size));
    }


    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s no encontrado", username)));
    }

    public User findById(Integer id){
        return userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No existe id: %d", id)));
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
