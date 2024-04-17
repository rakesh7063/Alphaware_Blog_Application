package com.blog.service;

import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.blog.model.User> opt= customerRepository.findByEmail(username);

        if(opt.isPresent()) {

            com.blog.model.User customer= opt.get();

            List<GrantedAuthority> authorities= new ArrayList<>();
            SimpleGrantedAuthority sga= new SimpleGrantedAuthority(customer.getRole());
            authorities.add(sga);


            return new User(customer.getEmail(), customer.getPassword(), authorities);




        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);





    }
}
