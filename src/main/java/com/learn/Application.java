package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.learn.models.User;
import com.learn.repository.UserRepository;

@SpringBootApplication
@Component
public class Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Osworld", bCryptPasswordEncoder.encode("micy345678"), "osworld@gmail.com", "ROLE_ADMIN");
		userRepository.save(user1);
		User user2 = new User("Henry", bCryptPasswordEncoder.encode("fishIceCream"), "henry@gmail.com", "ROLE_USER");
		userRepository.save(user2);
		
	}

}
