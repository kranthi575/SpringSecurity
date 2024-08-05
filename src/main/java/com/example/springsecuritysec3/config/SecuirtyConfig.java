package com.example.springsecuritysec3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import javax.sql.DataSource;

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

    //commenting below code to use custom details services
    //storing users data in application memory
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//
////        UserDetails user= User.withUsername("user1").password("{noop}qaz").authorities("user").build();
////        UserDetails admin=User.withUsername("admin").password("{bcrypt}$2a$12$l16zzDEuyWokORWN7V0qMOXj4vleYOI214dhQJB5iJyCr0s0OsfR2").authorities("admin").build();
////
////        return new InMemoryUserDetailsManager(user,admin);
//
//        //adding jdbc user details service to take data from database from tables users and authorities
//       return new JdbcUserDetailsManager(dataSource);
//    }

    //adding password encoder to decrypt the passwords as per requirements
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //this method helps us to check to is given password is compromised?
//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker(){
//        return new HaveIBeenPwnedRestApiPasswordChecker();
//    }




}
