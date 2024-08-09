package com.example.springsecuritysec3.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

   // private final UserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Object credentials=authentication.getCredentials();

        System.out.println(credentials.toString());

        //here we need take userdetails form database and verify with the data entered by the client
        //to loaduserby username we can use the custom userdetails service or else we can also implement the
        //loaduserbyusername in this method also
        //right-now I am trying to use custom user details service to load the details


        return authentication;
    }

    //need to specify what kind of authentication we are going to implement here like example UsernamePassword.,OAuth2,etc.
    //right-now for first time i am implementing usernamePassword authentication technique
    @Override
    public boolean supports(Class<?> authentication) {
        return TestingAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
