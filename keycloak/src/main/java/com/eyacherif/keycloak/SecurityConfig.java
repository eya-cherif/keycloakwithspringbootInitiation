package com.eyacherif.keycloak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf
                .disable())
                .authorizeHttpRequests(requests -> requests
                        .anyRequest()                               //this part is to authenticate all requests 
                        .authenticated());
        http.oauth2ResourceServer(server -> server
                .jwt());                                //here jwt needs to be validated using the oauth2resource server 

        http.sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); 
    return http.build(); 
    }

}
