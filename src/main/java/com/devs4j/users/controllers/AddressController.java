package com.devs4j.users.controllers;

import com.devs4j.users.entity.Address;
import com.devs4j.users.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users/id/{idUser}/profile/{idProfile}/address")
public class AddressController {

    @Autowired
    AddressService addressService;
    @GetMapping
    public ResponseEntity<List<Address>> getByUserIdAndProfileId(@PathVariable(value = "idUser") Integer idUser,
                                                                 @PathVariable(value = "idProfile") Integer idProfile){
        return new ResponseEntity<List<Address>>(addressService.getByUserIdAndProfileId(idUser,idProfile),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@PathVariable("idUser") Integer idUser,
                                                 @PathVariable("idProfile") Integer idProfile,
                                                 @RequestBody Address address){
        return new ResponseEntity<Address>(addressService.createAddress(idUser, idProfile, address), HttpStatus.CREATED);
    }


}
