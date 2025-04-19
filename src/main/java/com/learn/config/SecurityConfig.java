package com.learn.config;

import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.learn.services.CustomUserDetailService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
//		http
//		.csrf(csrf -> csrf.disable())
//		.authorizeHttpRequests(authorize -> authorize
//				.requestMatchers("/public/**").permitAll()
//				.requestMatchers("/users/**").hasRole("ADMIN")
//				.anyRequest()
//				.authenticated())
//		.httpBasic(Customizer.withDefaults());
		
//		http
//		.csrf(csrf -> csrf.disable())
//		.authorizeHttpRequests(authorize -> authorize
//				.requestMatchers("/signin").permitAll()
//				.requestMatchers("/public/**").permitAll()
//				.requestMatchers("/users/**").hasRole("ADMIN")
//				.anyRequest()
//				.authenticated())
//		.formLogin(form -> form.loginPage("/signin").loginProcessingUrl("/doLogin").defaultSuccessUrl("/users/"));
		
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/signin").permitAll()
				.requestMatchers("/public/**").permitAll()
				.requestMatchers("/users/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated())
		.formLogin(form -> form
		        .loginPage("/signin") // Optional: If you have a custom login page
		        .defaultSuccessUrl("/users/", true).permitAll());
		
		
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		
		
//		return new InMemoryUserDetailsManager(User.withUsername("Osworld")
//				.password("micy345678")
//				.roles("ADMIN")
//				.build(),
//				User.withUsername("Henry")
//				.password("fishIcdCream")
//				.roles("USER")
//				.build()
//				);
		
//	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(customUserDetailService); // your custom user service
	    authProvider.setPasswordEncoder(passwordEncoder());     // BCrypt encoder
	    return authProvider;
	}
	
//	 @Bean
//	  public PasswordEncoder passwordEncoder() {
//	        return NoOpPasswordEncoder.getInstance();
//	  }
	 
	 @Bean
	  public BCryptPasswordEncoder passwordEncoder() {  //used to persist password after encryption
	        return new BCryptPasswordEncoder(10);
	  }
	

}
