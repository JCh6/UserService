package com.juanchaparro.userservice;

import com.juanchaparro.userservice.domain.Role;
import com.juanchaparro.userservice.domain.User;
import com.juanchaparro.userservice.service.UserService;
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
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_MANAGER"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			userService.saveUser(new User("Juan Chaparro", "juan.chaparro", "123"));
			userService.saveUser(new User("Will Smith", "will.smith", "123"));
			userService.saveUser(new User("Jim Carry", "jim.carry", "123"));
			userService.saveUser(new User("Arnold Suarez Perez", "arnold.suarez", "123"));

			userService.addRoleToUser("juan.chaparro", "ROLE_USER");
			userService.addRoleToUser("juan.chaparro", "ROLE_MANAGER");
			userService.addRoleToUser("jim.carry", "ROLE_ADMIN");
		};
	}

}
