package com.devs4j.users.repositories;

import com.devs4j.users.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    @Query("SELECT a FROM Address a WHERE a.profile.user.id=?1 AND a.profile.id=?2 ")
    public List<Address> findByUserIdAndProfileId (Integer idUser, Integer idProfile);
}
