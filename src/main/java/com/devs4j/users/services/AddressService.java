package com.devs4j.users.services;

import com.devs4j.users.entity.Address;
import com.devs4j.users.entity.Profile;
import com.devs4j.users.entity.User;
import com.devs4j.users.repositories.AddressRepository;
import com.devs4j.users.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.builders.RequestHandlerSelectors;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public Address createAddress(Integer userId, Integer idProfile, Address address){
        Optional<Profile> profile = profileRepository.findByUserIdAndProfileId(userId, idProfile);
        if (profile.isPresent()){
            address.setProfile(profile.get());
            return addressRepository.save(address);
        }else throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("profile id %d no encontrado", profile));
    }
    public List<Address> getByUserIdAndProfileId(Integer idUser, Integer idProfile){
        return addressRepository.findByUserIdAndProfileId(idUser,idProfile);
    }
}
