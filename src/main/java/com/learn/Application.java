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
		User user1 = new User();
		user1.setEmail("osworld@gmail.com");
		user1.setUserName("Osworld");
		user1.setPassword(bCryptPasswordEncoder.encode("micy345678"));
		user1.setRole("ADMIN");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setEmail("henry@gmail.com");
		user2.setUserName("Henry");
		user2.setPassword(bCryptPasswordEncoder.encode("fishIceCream"));
		user2.setRole("USER");
		userRepository.save(user2);
		
	}

}
