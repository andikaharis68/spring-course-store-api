package com.enigma.api.inventory.services.Impl;

import com.enigma.api.inventory.entities.User;
import com.enigma.api.inventory.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    protected JpaRepository<User, Integer> repository;
    public UserDetailServiceImpl(JpaRepository<User, Integer> repository) {
        this.repository = repository;
    }

    public User save(User entity) {
        return repository.save(entity);
    }

    @Autowired
    private UserRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userInfoRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
}