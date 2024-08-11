package com.example.springsecuritysec3.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

   private final UserDetailsService userDetailsService;
   private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //retrieving user details
        String uname = authentication.getName();
        String upwd = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(uname);
        //here we need take userdetails form database and verify with the data entered by the client
        //to loaduserby username we can use the custom userdetails service or else we can also implement the
        //loaduserbyusername in this method also
        //right-now I am trying to use custom user details service to load the details

        //we can write valid assumptions and allow user without any passwordmatch
        //return new UsernamePasswordAuthenticationToken(uname, upwd, userDetails.getAuthorities());
        if (passwordEncoder.matches(upwd, userDetails.getPassword()))
            return new UsernamePasswordAuthenticationToken(uname, upwd, userDetails.getAuthorities());
        else
            throw new BadCredentialsException("Invalid password");
    }

    //need to specify what kind of authentication we are going to implement here like example UsernamePassword.,OAuth2,etc.
    //right-now for first time i am implementing usernamePassword authentication technique
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
