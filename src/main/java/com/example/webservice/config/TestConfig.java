package com.example.webservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webservice.entities.User;
import com.example.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Victoria", "choivivih0203@gmail.com","999429568","1230203");
		User u2 = new User(null, "Warley","warleycm7@gmail.com","999006478","123.321");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

	
}
