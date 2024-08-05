package com.example.springsecuritysec3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecuirtyConfig {

    //filter method :: starting point of the security
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/welcome").authenticated()
                .requestMatchers("/public","/").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    //
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user= User.withUsername("user1").password("{noop}qaz").authorities("user").build();
        UserDetails admin=User.withUsername("admin").password("{noop}admin").authorities("admin").build();

        return new InMemoryUserDetailsManager(user,admin);
    }



}
