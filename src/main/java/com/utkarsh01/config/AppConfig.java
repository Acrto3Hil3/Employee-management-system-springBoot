package com.utkarsh01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.utkarsh01.service.OwnUserService;

@Configuration
public class AppConfig {

	@Autowired
	private OwnUserService uService;

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(PasswordEncoder encoder) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(uService);
		provider.setPasswordEncoder(encoder);
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(request->request.disable())
		.authorizeHttpRequests((authorize)->{
			authorize.requestMatchers("/signUp","/register").permitAll();
			authorize.anyRequest().authenticated();})
		.formLogin(form->form.loginPage("/login").permitAll());
	return	http.build();
	}
	
}
