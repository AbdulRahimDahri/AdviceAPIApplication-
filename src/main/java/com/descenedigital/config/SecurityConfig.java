package com.descenedigital.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.descenedigital.model.Advice;
import com.descenedigital.repo.AdviceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
		return http.build();
	}

	@Bean
	CommandLineRunner init(AdviceRepo repo) {
		return args -> {
			if (repo.count() == 0) {
				repo.save(new Advice(null, "Stay consistent", 0.0, 0));
				repo.save(new Advice(null, "Read more documentation", 0.0, 0));
				repo.save(new Advice(null, "Ask clear questions", 0.0, 0));
			}
		};
	}

}