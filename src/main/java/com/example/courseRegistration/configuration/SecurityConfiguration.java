package com.example.courseRegistration.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.courseRegistration.service.UserService;


@Configuration
public class SecurityConfiguration {
	
	@Autowired
	UserService userService;
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity request){
		return request.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((response)->response
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
			.requestMatchers("/public/**").permitAll()
			.requestMatchers("/index.html").permitAll()
			.anyRequest().authenticated())
		
		.sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.httpBasic(Customizer.withDefaults())
		.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}

}
	
