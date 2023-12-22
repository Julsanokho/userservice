package com.sanokho.userservice;

import com.sanokho.userservice.domain.Role;
import com.sanokho.userservice.domain.User;
import com.sanokho.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Souleymane Sanokho", "julsanokho", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Bekaye Konate", "kb", "123kb", new ArrayList<>()));
			userService.saveUser(new User(null, "Sougoug malick", "elms", "123em", new ArrayList<>()));
			userService.saveUser(new User(null, "Iderissa Sidibe", "Bsidibe", "123bs", new ArrayList<>()));

			userService.addRoleToUser("julsanokho", "ROLE_ADMIN");
			userService.addRoleToUser("julsanokho", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("kb", "ROLE_MANAGER");
			userService.addRoleToUser("elms", "ROLE_USER");
			userService.addRoleToUser("Bsidibe", "ROLE_USER");
		};
	}
}
 