package com.restapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails firstUser =User.builder()
				.username("king")
				.password(passwordEncoder().encode("thapak"))
				.build();
		return new InMemoryUserDetailsManager(firstUser);
	          
	}
	
	
	  @Bean SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
	  { 
		  http .csrf(Csrf->Csrf .disable())
	  .authorizeHttpRequests(authorizeRequest->authorizeRequest
	  .requestMatchers("/test1","/test2","/test3","/excel/**").permitAll()
	  .requestMatchers( "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**",
	  "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
	  "/configuration/security", "/swagger-ui/**", "/webjars/**",
	  "/swagger-ui.html"
	  
	  ).permitAll() .anyRequest().authenticated() )
	  .httpBasic(Customizer.withDefaults());
	  
	  
	  return http.build(); 
	  
	  }
	 

}
