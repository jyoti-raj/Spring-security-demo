package com.learn.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.models.CustomUserDetail;
import com.learn.models.User;
import com.learn.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findById(username).orElse(null);
		if(user == null) {
			throw new UsernameNotFoundException("no user");
		}

		return org.springframework.security.core.userdetails.User.builder()
            .username(user.getUserName())
            .password(user.getPassword()) // should already be encoded
            .roles(user.getRole()) // or authorities
            .build();
//		return new CustomUserDetail(user);
	}
	
	

}
