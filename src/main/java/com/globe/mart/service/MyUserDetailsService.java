package com.globe.mart.service;



import com.globe.mart.model.User;
import com.globe.mart.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public User registerUser(User user) {
        if(!ObjectUtils.isEmpty(user)){
            try {
                return userRepository.save(user);
            } catch (Exception e){
                 log.error("Error while registering the user" + e.getMessage());
            }
        }
        return null;
    }
}
