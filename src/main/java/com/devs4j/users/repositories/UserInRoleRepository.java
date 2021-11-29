package com.devs4j.users.repositories;

import com.devs4j.users.entity.UserInRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Integer> {
}
