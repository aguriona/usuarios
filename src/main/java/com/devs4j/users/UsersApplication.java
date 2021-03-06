package com.devs4j.users;

import com.devs4j.users.entity.Role;
import com.devs4j.users.entity.User;
import com.devs4j.users.entity.UserInRole;
import com.devs4j.users.repositories.UserInRoleRepository;
import com.devs4j.users.services.RoleService;
import com.devs4j.users.services.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class UsersApplication implements ApplicationRunner {
	@Autowired
	Faker faker;

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserInRoleRepository userInRoleRepository;

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role roles [] = {new Role("ADMIN"),new Role("SUPPORT"),new Role("USER")};
		for (Role role : roles){
			roleService.saveRole(role);
		}

		for (int i=0; i<100; i++){
			User user = new User();
			user.setUsername(faker.artist().name());
			user.setPassword(faker.color().name());
			userService.createUser(user);

			UserInRole userInRole = new UserInRole(user, roles[new Random().nextInt(3)]);
			userInRoleRepository.save(userInRole);
		}
	}
}
