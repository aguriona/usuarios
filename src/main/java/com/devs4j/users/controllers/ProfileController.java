package com.devs4j.users.controllers;
import com.devs4j.users.entity.Profile;
import com.devs4j.users.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "users/id/{idUser}/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profile> getById(@PathVariable(value = "idUser") Integer idUser, @PathVariable(value = "id") Integer id){
        return new ResponseEntity<Profile>(profileService.getByUserIdAndProfileId(idUser,id),HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Profile> createProfile(@PathVariable(value = "idUser") Integer idUser, @RequestBody Profile profile){
        return new ResponseEntity<Profile>(profileService.createProfile(idUser, profile), HttpStatus.CREATED);
    }
}
