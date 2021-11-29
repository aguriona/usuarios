package com.devs4j.users.services;

import com.devs4j.users.entity.Profile;
import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.ProfileRepository;
import com.devs4j.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    public Profile createProfile(Integer id, Profile profile) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            profile.setUser(user.get());
            return profileRepository.save(profile);
        }else throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s no encontrado", user));


    }

    public Profile getByUserIdAndProfileId(Integer idUser, Integer idProfile) {
        return profileRepository.findByUserIdAndProfileId(idUser,idProfile).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile %d no encontrado", idProfile)));
    }
}
