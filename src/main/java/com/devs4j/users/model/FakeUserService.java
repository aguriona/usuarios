package com.devs4j.users.model;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeUserService {

    @Autowired
    private Faker faker;

    private List<FakeUser> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        for (int i =0; i<10; i++){
            users.add(new FakeUser(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }

    public List<FakeUser> getUsers() {
        return users;
    }

    public FakeUser findByUsername(String username){
      return users.stream().filter(user -> user.getUsername().equals(username)).findAny()
                           .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
    }

    public FakeUser createUser(FakeUser user){
        if (users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Ya Existe %s", user.getUsername()));
        }
        users.add(user);
        return user;
    }
}
